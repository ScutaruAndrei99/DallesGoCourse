package course2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercitiul2 {

    /** Exercițiul 2: Gestionarea unei companii de transport cu diferite tipuri de vehicule și calculul costurilor de
     * transport pentru o anumită rută:
     *
     *Cerință: Să se dezvolte un sistem pentru gestionarea unei companii de transport,
     * care să permită administrarea diferitelor tipuri de vehicule (ex. camioane, autobuze, mașini) și calculul
     * costurilor de transport pentru o anumită rută, luând în considerare distanța și tipul vehiculului.
     **/
    public static void main(String[] args) {
        Something something = new Something();
        something.startMenu();
    }

    public static class Something {
        Scanner scanner = new Scanner(System.in);

        public void startMenu() {
            System.out.println("Alege tipul de autovehicul pe care vrei sa il introduci");
            System.out.println("1. Camion");
            System.out.println("2. Autobuz");
            System.out.println("3. Masina");
            switch (scanner.nextInt()) {
                case 1:
                    meniuCamion();
                    break;
                case 2:
                    meniuAutobuz();
                    break;
                case 3:
                    meniuMasina();
                    break;
            }
        }
        public void meniuAutobuz() {
            Autobuz autobuz = new Autobuz("", "", 2, "Camion");
            System.out.println("Scrie cifra aferenta actiunii pe care vrei sa o faci");
            System.out.println("1. Afiseaza autobuzele din stock");
            System.out.println("2. Adauga un alt autobuz");
            System.out.println("3. Calculeaza pretul deplasarii");
            System.out.println("4. Exit.");

            switch (scanner.nextInt()) {
                case 1:
                    autobuz.afiseazaAutobuzeStock();
                    meniuAutobuz();
                    break;
                case 2:
                    autobuz.addAutobuz();
                    meniuAutobuz();
                    break;
                case 3:
                    autobuz.calculCostTransport();
                    meniuAutobuz();
                    break;
                case 4:
                    startMenu();
                    break;
            }
        }

        public void meniuMasina() {
            Masina masina = new Masina("", "", 3, "Masina");
            System.out.println("Scrie cifra aferenta actiunii pe care vrei sa o faci");
            System.out.println("1. Afiseaza masinile din stock");
            System.out.println("2. Adauga o alta masina");
            System.out.println("3. Calculeaza pretul deplasarii");
            System.out.println("4. Exit.");

            switch (scanner.nextInt()) {
                case 1:
                    masina.afiseazaMasinaStock();
                    meniuMasina();
                    break;
                case 2:
                    masina.addMasina();
                    meniuMasina();
                    break;
                case 3:
                    masina.calculCostTransport();
                    meniuMasina();
                    break;
                case 4:
                    startMenu();
                    break;
            }
        }

//        public void meniuAutobuz() {
//            Autobuz autobuz = new Autobuz("", "", 2, "Camion");
//            System.out.println("Scrie cifra aferenta actiunii pe care vrei sa o faci");
//            System.out.println("1. Afiseaza autobuzele din stock");
//            System.out.println("2. Adauga un alt autobuz");
//            System.out.println("3. Calculeaza pretul deplasarii");
//            System.out.println("4. Exit.");
//
//            switch (scanner.nextInt()) {
//                case 1:
//                    autobuz.afiseazaAutobuzeStock();
//                    meniuAutobuz();
//                    break;
//                case 2:
//                    autobuz.addAutobuz();
//                    meniuAutobuz();
//                    break;
//                case 3:
//                    autobuz.calculCostTransport();
//                    meniuAutobuz();
//                    break;
//                case 4:
//                    startMenu();
//                    break;
//            }
//        }

        public void meniuCamion() {
            Camion camion = new Camion("FM 420", "Volvo", 29, "Camion");
            System.out.println("Scrie cifra aferenta actiunii pe care vrei sa o faci");
            System.out.println("1. Afiseaza camioanele din stock");
            System.out.println("2. Adauga un alt camion");
            System.out.println("3. Calculeaza pretul deplasarii");
            System.out.println("4. Exit.");

            switch (scanner.nextInt()) {
                case 1:
                    camion.afiseazaCamioaneStock();
                    meniuCamion();
                    break;
                case 2:
                    camion.addCamion();
                    meniuCamion();
                    break;
                case 3:
                    camion.calculCostTransport();
                    meniuCamion();
                    break;
                case 4:
                    startMenu();
                    break;
            }
        }
    }

    public abstract static class Autovehicul {
        protected String nume;
        protected String marca;
        protected double consum;
        Scanner scanner = new Scanner(System.in);

        public Autovehicul(String nume, String marca, double consum) {
            this.nume = nume;
            this.marca = marca;
            this.consum = consum;
        }

        public double getConsum() {
            return consum;
        }

        public abstract void calculCostTransport();
    }

    public static class Camion extends Autovehicul {
        protected String tipulAutovehiculului;
        public static List<Camion> listaCamioane = new ArrayList<>();

        public Camion(String nume, String marca, double consum, String tipulAutovehiculului) {
            super(nume, marca, consum);
            this.tipulAutovehiculului = tipulAutovehiculului;
        }

        @Override
        public double getConsum() {
            return super.getConsum();
        }

        public List<Camion> addCamion() {
            System.out.println("Introdu camionul de forma:");
            System.out.println("Nume, Marca, Consum");
            Camion camion = new Camion(scanner.next(), scanner.next(), scanner.nextDouble(), "Camion");
            listaCamioane.add(camion);
            return listaCamioane;
        }

        public void afiseazaCamioaneStock() {
            if (listaCamioane.isEmpty()){
                System.out.println("Nu ai nici un camion in proprietate");
            } else {
                System.out.println("Ai urmatoarele camioane: ");
                for (Camion camion : listaCamioane) {
                    System.out.println(camion.nume + ", " + camion.marca + ", " + camion.consum);
                }
            }
        }

        @Override
        public void calculCostTransport() {
            System.out.println("Acestea sunt camioanele pe care le poti verifica:");
            for (Camion camion : listaCamioane) {
                System.out.println(camion.nume + " " +camion.consum);
            }
            System.out.println("Scrie numele camionului pentru care vrei sa calculezi costul carburantului: ");
            String preferinta = scanner.next();
            for(Camion camion :listaCamioane){
                if (camion.nume.equals(preferinta)) {
                    System.out.print("Scrie numarul de kilometri pe care vrei sa ii parcurgi: ");
                    double kmParcursi = scanner.nextDouble();
                    System.out.print("Scrie pretul carburantului din acest moment: ");
                    double pretCarburant = scanner.nextDouble();
                    double costTransport = kmParcursi / 100 * camion.consum * pretCarburant;
                    System.out.println("Costul deplasarii este de: " + costTransport);
                } else {
                    System.out.println("Alege alt camion ");
                }
            }

        }

    }

    public static class Autobuz extends Autovehicul {
        protected String tipulAutovehiculului;
        public static List<Autobuz> listaAutobuz = new ArrayList<>();

        public Autobuz(String nume, String marca, double consum, String tipulAutovehiculului) {
            super(nume, marca, consum);
            this.tipulAutovehiculului = tipulAutovehiculului;
        }

        @Override
        public double getConsum() {
            return super.getConsum();
        }

        public List<Autobuz> addAutobuz() {
            System.out.println("Introdu autobuzul de forma:");
            System.out.println("Nume, Marca, Consum");
            Autobuz autobuz = new Autobuz(scanner.next(), scanner.next(), scanner.nextDouble(), "Autobuz");
            listaAutobuz.add(autobuz);
            return listaAutobuz;
        }

        public void afiseazaAutobuzeStock() {
            if (listaAutobuz.isEmpty()){
                System.out.println("Nu ai nici un autobuz in proprietate");
            } else {
                System.out.println("Ai urmatoarele autobuze: ");
                for (Autobuz autobuz : listaAutobuz) {
                    System.out.println(autobuz.nume + ", " + autobuz.marca + ", " + autobuz.consum);
                }
            }
        }

        @Override
        public void calculCostTransport() {
            System.out.println("Acestea sunt autobuze pe care le poti verifica:");
            for (Autobuz autobuz : listaAutobuz) {
                System.out.println(autobuz.nume + " " +autobuz.consum);
            }
            System.out.println("Scrie numele autobuzului pentru care vrei sa calculezi costul carburantului: ");
            String preferinta = scanner.next();
            for(Autobuz autobuz : listaAutobuz){
                if (autobuz.nume.equals(preferinta)) {
                    System.out.print("Scrie numarul de kilometri pe care vrei sa ii parcurgi: ");
                    double kmParcursi = scanner.nextDouble();
                    System.out.print("Scrie pretul carburantului din acest moment: ");
                    double pretCarburant = scanner.nextDouble();
                    double costTransport = kmParcursi / 100 * autobuz.consum * pretCarburant;
                    System.out.println("Costul deplasarii este de: " + costTransport);
                } else {
                    System.out.println("Alege alt autobuz ");
                }
            }

        }

    }

    public static class Masina extends Autovehicul {
        protected String tipulAutovehiculului;
        public static List<Masina> listaMasina = new ArrayList<>();

        public Masina(String nume, String marca, double consum, String tipulAutovehiculului) {
            super(nume, marca, consum);
            this.tipulAutovehiculului = tipulAutovehiculului;
        }

        @Override
        public double getConsum() {
            return super.getConsum();
        }

        public List<Masina> addMasina() {
            System.out.println("Introdu masina de forma:");
            System.out.println("Nume, Marca, Consum");
            Masina masina = new Masina(scanner.next(), scanner.next(), scanner.nextDouble(), "Masina");
            listaMasina.add(masina);
            return listaMasina;
        }

        public void afiseazaMasinaStock() {
            if (listaMasina.isEmpty()){
                System.out.println("Nu ai nici o masina in proprietate");
            } else {
                System.out.println("Ai urmatoarele masini: ");
                for (Masina masina : listaMasina) {
                    System.out.println(masina.nume + ", " + masina.marca + ", " + masina.consum);
                }
            }
        }

        @Override
        public void calculCostTransport() {
            System.out.println("Acestea sunt masinile pe care le poti verifica:");
            for (Masina masina : listaMasina) {
                System.out.println(masina.nume + " " +masina.consum);
            }
            System.out.println("Scrie numele masinii pentru care vrei sa calculezi costul carburantului: ");
            String preferinta = scanner.next();
            for(Masina masina : listaMasina){
                if (masina.nume.equals(preferinta)) {
                    System.out.print("Scrie numarul de kilometri pe care vrei sa ii parcurgi: ");
                    double kmParcursi = scanner.nextDouble();
                    System.out.print("Scrie pretul carburantului din acest moment: ");
                    double pretCarburant = scanner.nextDouble();
                    double costTransport = kmParcursi / 100 * masina.consum * pretCarburant;
                    System.out.println("Costul deplasarii este de: " + costTransport);
                } else {
                    System.out.println("Alege alta masina ");
                }
            }

        }

    }
}
