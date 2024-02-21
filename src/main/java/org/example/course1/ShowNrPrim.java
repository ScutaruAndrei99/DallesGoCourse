package org.example.course1;

public class ShowNrPrim {
    public static void main(String[] args) {
        int nrPrim=0;

        System.out.println("scrie numarul");

        for (int i=2;nrPrim<12;i++){
            if(estePrim(i)) {
                System.out.println(i);
                nrPrim++;
            }
        }
    }
    public static boolean estePrim(int i) {
        if(i<=1){
            return false;
        }
        for (int j=2; j<=Math.sqrt(i); j++) {
            if (i%j==0){
                return false;
            }
        }
        return true;
    }
}
