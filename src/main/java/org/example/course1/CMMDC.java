package org.example.course1;

public class CMMDC {
    public static void main(String[] args) {
        int a = 68;
        int b= 246;
        while (a!=b) {
            if(a>b){
                a=a-b;
            } else {
                b=b-a;
            }
        }
        System.out.println(a);
    }
}
