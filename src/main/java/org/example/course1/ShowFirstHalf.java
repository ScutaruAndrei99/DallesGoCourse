package org.example.course1;

public class ShowFirstHalf {
    public static void main(String[] args) {
        String text = "Sir de caractere";
        int length = text.length();
        int halfLength = length / 2;

        System.out.println("prima jumatate a sirului folosind forEach:");
        text.chars().limit(halfLength).forEach(c -> System.out.print((char) c));
        System.out.println();
    }
}
