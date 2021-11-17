package com.company;

public class TesteConverter {

    public static void main(String[] args) {
        byte a = -30;

        int b = (int) a;
        if (b < 0){
            b = (b*-1)+128;
        }


            System.out.println(b);
    }

}