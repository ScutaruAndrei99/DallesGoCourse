package org.example.course1;

public class SumNumber {
    public static void main(String[] args) {
        int x=555;
        int sum=0;
        while (x!=0){
            sum=sum+x%10;
            x=x/10;
        }
        System.out.println(sum);
    }
}
