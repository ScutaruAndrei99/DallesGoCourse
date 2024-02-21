package course2.gestionareMagazin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdusPerisabil extends Produs{
    Date dataExpirare;
    Date dataIntrare;
    public ProdusPerisabil(ProdusPerisabil.ExtendedBuilder builder) {
        super(builder);
        this.dataExpirare = builder.dataExpirare;
        this.dataIntrare=builder.dataIntrare;
    }
    public static class ExtendedBuilder extends Produs.ProdusBuilder {
        private Date dataIntrare;
        private Date dataExpirare;
        public ProdusPerisabil.ExtendedBuilder dataIntrare(Date dataIntrare){
            this.dataIntrare=dataIntrare;
            return this;
        }
        public ProdusPerisabil.ExtendedBuilder dataExpire(Date dataExpirare){
            this.dataExpirare=dataExpirare;
            return this;
        }
        @Override
        public ProdusPerisabil build() {
            return new ProdusPerisabil(this);
        }
        @Override
        public String toString(){
            return build().nume+ " "+
                    build().unitateMasura+ " " +
                    build().cantitate+ " " +
                    build().dataIntrare+ " " +
                    build().dataExpirare;
        }
    }

    public List<ProdusPerisabil> listaProdusPerisabil=new ArrayList<>();

    @Override
    public void addLot() {
        super.addLot();
        String nume = super.nume;
        String unitateMasura = super.unitateMasura;
        double cantitate = super.cantitate;

        Date dataIntrare;
        Date dataExpirare;

        System.out.println("Introduceți data de intrare (yyyy-MM-dd): ");
        String dataIntrareString= scanner.nextLine();
        System.out.println("Introduceți data de expirare (yyyy-MM-dd): ");
        String dataExpirareString= scanner.nextLine();

        try {
            SimpleDateFormat simpleDataExpirare = new SimpleDateFormat("yyyy-MM-dd");
            dataExpirare = simpleDataExpirare.parse(dataExpirareString);
            SimpleDateFormat simpleDataIntrare = new SimpleDateFormat("yyyy-MM-dd");
            dataIntrare = simpleDataIntrare.parse(dataIntrareString);

            ProdusPerisabil produsPerisabil= (ProdusPerisabil) new ProdusPerisabil.ExtendedBuilder()
                    .dataIntrare(dataIntrare)
                    .dataExpire(dataExpirare)
                    .name(nume)
                    .cantitate(cantitate)
                    .unitateMasura(unitateMasura)
                    .build();
            listaProdusPerisabil.add(produsPerisabil);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void afiseazaLotulPerisabil(){

        for(ProdusPerisabil produsPerisabil:listaProdusPerisabil){
            System.out.println("Nume: " +produsPerisabil.nume+
                    "; UM: " +produsPerisabil.unitateMasura+
                    "; Cantitate: " + produsPerisabil.cantitate+
                    "; Data intrare: " +produsPerisabil.dataIntrare +
                    "; Data expirare: " + produsPerisabil.dataIntrare +";");
        }
    }

    public void afiseazaLotulPerisabilInterval(){
        Date startDate;
        Date endDate;

        System.out.println("Introduceți intai data de cand vrei sa cauti (yyyy-MM-dd): ");
        String startDateString= scanner.nextLine();
        System.out.println("Introduceți data pana cand vrei sa verifici (yyyy-MM-dd): ");
        String endDateString= scanner.nextLine();

        try {
            SimpleDateFormat simpleStartDate = new SimpleDateFormat("yyyy-MM-dd");
            startDate = simpleStartDate.parse(startDateString);

            SimpleDateFormat simpleEndDate = new SimpleDateFormat("yyyy-MM-dd");
            endDate = simpleEndDate.parse(endDateString);

            for(ProdusPerisabil produsPerisabil:listaProdusPerisabil){
                Date arrivalDate = produsPerisabil.dataIntrare;

                if (arrivalDate.after(startDate) && arrivalDate.before(endDate)) {
                    System.out.println("Nume: " + produsPerisabil.nume +
                            "; UM: " + produsPerisabil.unitateMasura +
                            "; Cantitate: " + produsPerisabil.cantitate +
                            "; Data intrare: " + produsPerisabil.dataIntrare +
                            "; Data expirare: " + produsPerisabil.dataIntrare + ";");
                }
            }

        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void afiseazaProduselePerisabileAccesibileVanzarii(){
        Date currentDate = new Date();

        for(ProdusPerisabil produsPerisabil:listaProdusPerisabil){
            Date arrivalDate = produsPerisabil.dataIntrare;

            if (arrivalDate.after(currentDate) && produsPerisabil.cantitate!=0) {
                System.out.println("Nume: " + produsPerisabil.nume +
                        "; UM: " + produsPerisabil.unitateMasura +
                        "; Cantitate: " + produsPerisabil.cantitate +
                        "; Data intrare: " + produsPerisabil.dataIntrare +
                        "; Data expirare: " + produsPerisabil.dataIntrare + ";");
            }
        }

    }
}
