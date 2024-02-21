package org.example.course1;

import java.util.Scanner;

public class NrPrim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("scrie numarul");
        int nr = scanner.nextInt();

        if(estePrim(nr)) {
            System.out.println("nr este prim");
        } else {
            System.out.println("nr nu este prim");
        }
    }
    public static boolean estePrim(int nr) {
        if(nr<=1){
            return false;
        }
        for (int i=2; i<=Math.sqrt(nr); i++) {
            if (nr%i==0){
                return false;
            }
        }
        return true;
    }
}
