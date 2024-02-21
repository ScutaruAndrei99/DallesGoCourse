package course2;

/**
 * Exercițiul 3: Gestionarea unui sistem bancar cu diferite tipuri de conturi și calculul dobânzilor câștigate:
 *
 * Cerință: Să se creeze un sistem pentru gestionarea unei bănci, care să permită administrarea diferitelor
 * tipuri de conturi bancare (ex. conturi curente, conturi de economii, conturi de investiții) și calculul dobânzilor
 * câștigate pentru fiecare cont în funcție de tip și soldul actual.
 */
public class Evercitiul3 {

    public static void main(String[] args) {
        // Creare conturi bancare
        ContBancar cont1 = new ContCurent("12345", 1000);
        ContBancar cont2 = new ContEconomii("67890", 2000, 0.05);
        ContBancar cont3 = new ContInvestitii("54321", 3000, 0.08);

        // Calculare dobanzi
        cont1.calculeazaDobanda();
        cont2.calculeazaDobanda();
        cont3.calculeazaDobanda();
    }

    // Clasa abstracta pentru conturile bancare
    public abstract static class ContBancar {
        protected String numarCont;
        protected double sold;

        public ContBancar(String numarCont, double sold) {
            this.numarCont = numarCont;
            this.sold = sold;
        }

        public abstract void calculeazaDobanda();
    }

    // Clasa pentru conturile curente
    public static class ContCurent extends ContBancar {
        public ContCurent(String numarCont, double sold) {
            super(numarCont, sold);
        }

        @Override
        public void calculeazaDobanda() {
            // Conturile curente nu au dobândă
            System.out.println("Cont curent " + numarCont + ": Nu se calculeaza dobanda pentru conturile curente");
        }
    }

    // Clasa pentru conturile de economii
    public static class ContEconomii extends ContBancar {
        private double rataDobanda;

        public ContEconomii(String numarCont, double sold, double rataDobanda) {
            super(numarCont, sold);
            this.rataDobanda = rataDobanda;
        }

        @Override
        public void calculeazaDobanda() {
            double dobanda = sold * rataDobanda;
            System.out.println("Cont economii " + numarCont + ": Dobanda curenta este " + dobanda);
        }
    }

    // Clasa pentru conturile de investitii
    public static class ContInvestitii extends ContBancar {
        private double rataDobanda;

        public ContInvestitii(String numarCont, double sold, double rataDobanda) {
            super(numarCont, sold);
            this.rataDobanda = rataDobanda;
        }

        @Override
        public void calculeazaDobanda() {
            double dobanda = sold * rataDobanda * 1.5; // Oferim un bonus de 50% pentru conturile de investitii
            System.out.println("Cont investitii " + numarCont + ": Dobanda curenta este " + dobanda);
        }
    }
}

