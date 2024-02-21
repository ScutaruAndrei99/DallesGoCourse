package course2.gestionareMagazin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdusPromotional extends Produs{
    double discount;
    Date dataIntrare;
    public static List<ProdusPromotional> listaProdusPromotional= new ArrayList<>();

    public ProdusPromotional(ProdusPromotional.ExtendedBuilder builder) {
        super(builder);
        this.discount = builder.discount;
        this.dataIntrare=builder.dataIntrare;
    }
    public static class ExtendedBuilder extends Produs.ProdusBuilder {
        private double discount;
        private Date dataIntrare;
        public ProdusPromotional.ExtendedBuilder discount(double discount){
            this.discount=discount;
            return this;
        }
        public ProdusPromotional.ExtendedBuilder dataIntrare(Date dataIntrare){
            this.dataIntrare=dataIntrare;
            return this;
        }
        @Override
        public ProdusPromotional build() {
            return new ProdusPromotional(this);
        }
        @Override
        public String toString(){
            return build().nume+ " "+
                    build().unitateMasura+ " " +
                    build().cantitate+ " " +
                    build().dataIntrare+ " " +
                    build().discount;
        }

    }
    @Override
    public void addLot() {
        super.addLot();

        String nume = super.nume;
        String unitateMasura = super.unitateMasura;
        double cantitate = super.cantitate;

        System.out.println("Introdu discount-ul pe care vrei sa il aplici");
        double discount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Introduceți data de intrare (yyyy-MM-dd): ");
        String dataIntrareString= scanner.nextLine();
        Date dataIntrare = null;
        try {
            dataIntrare = new SimpleDateFormat("yyyy-MM-dd").parse(dataIntrareString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ProdusPromotional produsPromotional= (ProdusPromotional) new ProdusPromotional.ExtendedBuilder()
                .discount(discount).dataIntrare(dataIntrare).name(nume).cantitate(cantitate)
                .unitateMasura(unitateMasura).build();
        listaProdusPromotional.add(produsPromotional);
    }
    public void afiseazaLotulPromotional(){
        for(ProdusPromotional produsPromotional:listaProdusPromotional){
            System.out.println("Nume: " +produsPromotional.nume+
                    "; UM: " +produsPromotional.unitateMasura+
                    "; Cantitate: " + produsPromotional.cantitate+
                    "; Data intrare: " +produsPromotional.dataIntrare +
                    "; Discount: " + produsPromotional.discount +"%;");
        }
    }

}
