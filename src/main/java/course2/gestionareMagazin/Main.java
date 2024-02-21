package course2.gestionareMagazin;

/**
 * Un magazin și-a propus să implementeze un program Java, orientat pe obiecte, cu ajutorul căruia să își gestioneze
 * produsele. Fiecare produs comercializat de magazin are o unitate de măsura care poate fi bucată, greutate sau volum.
 * Unele produse pot fi perisabile (au o perioadă de valabilitate). Unele produse pot fi în promoție (la prețul de
 * vânzare se aplică un discount – procent din preț).
 *
 * Magazinul primeste produsele sub forma de loturi. Un lot reprezintă o anumită cantitate dintr-un produs, primită
 * la o anumită dată de magazin și care trebuie vândută la un anumit preț per unitatea de măsură a produsului.
 * Două loturi diferite din același produs pot veni în magazin în cantități diferite sau la prețuri diferite.
 * Produsele perisabile au în plus o perioadă de valabilitate care poate fi diferită pentru fiecare lot în parte și se
 * calculează de la data intrării lotului în magazin. Produsele în promoție au în plus un procent de discount care
 * poate fi diferit pentru fiecare lot în parte și se aplică prețului cu care a intrat în magazin acel lot din produs.
 *
 * De exemplu:
 *      pe data de 03.05.2024, magazinul primește un lot de 150 kg de cireșe, cu termen de valabilitate de 5 zile, la
 * prețul de 20 lei pe kg
 *      pe data de 05.05.2024, magazinul primește un lot de 500 de căciuli, la prețul de 15 lei bucata
 *      pe data de 16.05.2024, magazinul primește un lot de 300 kg de cireșe, cu termen de valabilitate de 3 zile, la
 * prețul de 15 lei pe kg, la care decide să aplice un discount de 20%
 *      pe data de 19.05.2015, magazinul primește un lot de 100 de litri de rom, la prețul de 25 de lei pe litru, la care
 * decide să aplice un discount de 10%.
 *
 * Progamul trebuie să citească de la tastatură loturile de produse cu toate informațiile aferente, câte unul pe rând,
 * în formatul cel mai convenabil, să creeze o structură de date în care să le adauge și să le afișeze împreună cu
 * toate informațiile lor curente, în funcție de opțiunea vânzătorului.
 *
 * Un vânzător din magazin poate să opteze între:
 *      a adăuga un produs nou
 *      a afișa toate produsele pe care magazinul le poate comercializa
 *      a adăuga un lot nou dintr-un produs
 *      a afișa toate loturile de produse care au fost primite de magazin între două date calendaristice date
 *      a afișa toate loturile de produse care pot fi comercializate de magazin la data curentă (care sunt nevide și
 *care nu sunt expirate)
 *      a vinde o anumită cantitate cerută dintr-un produs pe care îl are în magazin.
 *
 * Când primește o cerere de vânzare a unui produs, vânzătorul trebuie să verifice dacă are în magazin cel puțin un lot
 * din acel produs, în cantitate cel puțin egală cu cererea și care nu a depășit data de valabilitate. Dacă în magazin
 * există mai multe loturi din acel produs, în cantități mai mari sau egale decât cantitatea cerută și care sunt în
 * termenul de valabilitate, atunci magazinul este obligat să vândă din lotul mai ieftin. Dacă vânzarea se poate face,
 * aplicația trebuie să afișeze prețul total pentru cantitatea solicitată. Dacă există mai multe loturi din acel produs
 * care pot fi comercializate, dar niciunul nu este într-o cantitate mai mare sau egală decât cea solicitată, atunci
 * programul trebuie să afișeze cantitățile disponibile în fiecare lot comercializabil, cu prețul corespunzător.
 * O vânzare nu se poate face din mai multe loturi disponibile; cantitatea vândută o dată trebuie să fie dintr-un
 * singur lot. După finalizarea vânzării, cantitatea vândută se scade din cantitatea disponibilă în stocul din care s-a
 * făcut vânzarea.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.startMeniu();
    }

    public Produs produs=new Produs.ProdusBuilder().build();
    public  ProdusPerisabil produsPerisabil=new ProdusPerisabil.ExtendedBuilder().build();
    public ProdusPromotional produsPromotional=new ProdusPromotional.ExtendedBuilder().build();

    public void startMeniu(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege cifra corespunzatoare actiunii pe care vrei sa o faci");
        System.out.println("1. Adauga un produs nou");
        System.out.println("2. Afiseaza toate produsele pe care le comercializez");
        System.out.println("3. Adauga un lot nou dintr-un produs");
        System.out.println("4. Afișeaza loturile de produse care au fost primite de magazin între două date " +
                "calendaristice date");
        System.out.println("5. Afișa loturile de produse care pot fi comercializate de magazin la data " +
                "curentă care sunt nevide și care nu sunt expirate");
        switch (scanner.nextInt()) {
            case 1:
                produs.addProdus();
                startMeniu();
                break;
            case 2:
                produs.afiseazaProdusele();
                startMeniu();
                break;
            case 3:
                tipLot();
                break;
            case 4:
                produsPerisabil.afiseazaLotulPerisabilInterval();
                startMeniu();
                break;
            case 5:
                produsPerisabil.afiseazaProduselePerisabileAccesibileVanzarii();
                startMeniu();
                break;
        }

    }
    public void tipLot(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege ce fel de lot vrei sa bagi");
        System.out.println("1. Perisabil");
        System.out.println("2. Afiseaza loturile produselor perisabile");
        System.out.println("3. Promotional");
        System.out.println("4. Afiseaza loturile produselor Promotionale");
        System.out.println("5. Inapoi");
        switch (scanner.nextInt()){
            case 1:
                produsPerisabil.addLot();
                tipLot();
                break;
            case 2:
                produsPerisabil.afiseazaLotulPerisabil();
                tipLot();
                break;
            case 3:
                produsPromotional.addLot();
                tipLot();
                break;
            case 4:
                produsPromotional.afiseazaLotulPromotional();
                tipLot();
                break;
            case 5:
                startMeniu();
                break;
        }
    }

}
