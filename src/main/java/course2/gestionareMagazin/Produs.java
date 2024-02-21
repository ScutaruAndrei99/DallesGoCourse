package course2.gestionareMagazin;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produs {
    public Main main;
    public Scanner scanner = new Scanner(System.in);
    String nume;
    String unitateMasura;
    double cantitate;
    public List<Produs> listaProduse=new ArrayList<>();

    public Produs(Produs.ProdusBuilder builder) {
        this.nume = builder.nume;
        this.unitateMasura = builder.unitateMasura;
        this.cantitate=builder.cantitate;
    }
    public static class ProdusBuilder{
        private String nume;
        private String unitateMasura;
        private double cantitate;
        //
        public Produs.ProdusBuilder name(String nume){
            this.nume=nume;
            return this;
        }
        public Produs.ProdusBuilder unitateMasura(String unitateMasura){
            this.unitateMasura=unitateMasura;
            return this;
        }
        public Produs.ProdusBuilder cantitate(double cantitate){
            this.cantitate=cantitate;
            return this;
        }
        public Produs build(){
            return new Produs(this);
        }
    }
    public void addProdus(){
        System.out.println("Scrie numele produsului pe care vrei sa il adaugi");
        Produs produs= new Produs.ProdusBuilder().name(scanner.next()).build();
        listaProduse.add(produs);
    }
    public void afiseazaProdusele(){
        for(int i=0; i<listaProduse.size();i++) {
            Produs produs =listaProduse.get(i);
            if (i < listaProduse.size() - 1) {
                System.out.print(produs.nume + ", ");
            } else {
                System.out.println(produs.nume);
            }
        }
    }
    public void addLot(){
        System.out.print("Introduceti numele produsului pentru care vreti sa alimentati magazinul: ");
        nume = scanner.nextLine();
        for (Produs produs : listaProduse){
            if(produs.nume.equals(nume)){

            } else {
                System.out.println("Produsul nu a fost gasit, te rog sa introduci produl mai intai");
                main.tipLot();
                break;
            }
        }
        System.out.print("Introduceți unitatea de măsură: ");
        unitateMasura = scanner.nextLine();
        System.out.print("Introduceti cantitatea: ");
        cantitate = scanner.nextDouble();
        scanner.nextLine();
    }
}

