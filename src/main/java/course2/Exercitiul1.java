package course2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercitiul1 {
    /** Exercițiul 1: Gestionarea unei rețele de magazine de retail cu diferite tipuri de
     * produse și calculul veniturilor totale:
     *
     * Cerință: Să se creeze un sistem pentru gestionarea unei rețele de magazine de retail, care să permită
     administrarea diferitelor tipuri de produse (ex. alimente, îmbrăcăminte, electrocasnice) și calculul veniturilor
     totale din vânzări pentru întreaga rețea.
     **/

    public static void main(String[] args) {
        Produs produs = new Produs("magazinA", "avocado", 10);
        List<Produs> cos = produs.cosCumparaturi();

        produs.sortareDupaNume(cos);
        System.out.println();
        produs.sortareDupaPret(cos);
        System.out.println();

        System.out.println("Suma totala de plata pentru toate produsele din cos: " + produs.calculProdus());
    }

    public abstract static class Magazin {
        protected String nameMagazin;

        public Magazin(String nameMagazin) {
            this.nameMagazin = nameMagazin;
        }

        public abstract int calculProdus();
    }

    public static class Produs extends Magazin {
        private String nameProdus;
        private int pretProdus;

        public Produs(String nameMagazin, String nameProdus, int pretProdus) {
            super(nameMagazin);
            this.nameProdus = nameProdus;
            this.pretProdus = pretProdus;
        }

        public String getNameProdus() {
            return nameProdus;
        }


        public int getPretProdus() {
            return pretProdus;
        }


        public List<Produs> cosCumparaturi() {
            List<Produs> cosCumparaturi = new ArrayList<>();
            cosCumparaturi.add(new Produs("magazinA", "avocado", 10));
            cosCumparaturi.add(new Produs("magazinA", "banane", 3));
            cosCumparaturi.add(new Produs("magazinA", "mere", 7));
            cosCumparaturi.add(new Produs("magazinA", "castraveti", 9));
            return cosCumparaturi;
        }

        @Override
        public int calculProdus() {
            int sum = 0;
            for (Produs produs : cosCumparaturi()) {
                sum += produs.getPretProdus();
            }
            return sum;
        }

        public void sortareDupaNume(List<Produs> cos) {
            cos.sort(Comparator.comparing(Produs::getNameProdus));
            for (Produs produs : cos) {
                System.out.println("Produs: " + produs.getNameProdus() + ", Pret: " + produs.getPretProdus());
            }
        }

        public void sortareDupaPret(List<Produs> cos) {
            cos.sort(Comparator.comparingInt(Produs::getPretProdus));
            for (Produs produs : cos) {
                System.out.println("Produs: " + produs.getNameProdus() + ", Pret: " + produs.getPretProdus());
            }
        }
    }
}

