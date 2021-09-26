package com.company;


import java.util.Arrays;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;
public class Converter {

    public static void Convert(byte[]  a) {

        String c = "";
        for (int letter: a) {
            if (letter == 0){
                continue;
            }
            if (letter == -2){
                c = c+":";
                continue;
            }
            if (letter ==  -1){
                c = c+" ";
                continue;
            }
           // int b = Integer.parseInt(letter);
             c = c+(char)letter;

        }

        Map<String,String> salas = new HashMap<String,String>();
        String parts[] = c.split(" ");
        for( String part : parts){

            String data[] = part.split(":");

            String key = data[0].trim();
            String value = data[1].trim();
            salas.put(key, value);

        }
        System.out.println("Lista:" + salas);

    }
    public static void Verify(byte[] dep){
        if (dep.length == dep[1] && dep[dep.length-3] == 3 && dep[dep.length-1] == 4){
            System.out.println("Frame ok");
          byte[] lista = Arrays.copyOfRange(dep, 14,dep.length-3);
          String r = Arrays.toString(lista);
            Convert(lista);
        }
    }


    public static void main(String[] args) {

    }
}