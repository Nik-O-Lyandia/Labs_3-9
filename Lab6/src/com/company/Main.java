package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,String> Words = new HashMap<String, String>() {{
            put("exit","вихід");
            put("case","обставина");
            put("nonviolent","ненасильницький");
            put("scholars","вчені");
            put("preliminary","попередній");
            put("prior","до");
            put("coverage","покриття");
            put("attendance","відвідування");
            put("accommodation","проживання");
            put("consider","розглядати");
            put("facilities","зручності");
            put("streamline","впорядкувати");
            put("aimed","направлений");
            put("obtaining","отримання");
            put("applicable","який можна застосовувати");
            put("specify","вказувати");
            put("fill","заповнювати");
            put("surface","поверхню");
            put("volume","обсяг");
            put("catchy","той, що добре запам'ятовується");
            put("consistent","послідовний");
            put("niche","ніша");
            put("charge","заряджати/звинувачувати");
            put("estimate","оцінювати");
            put("to be keen to","прагнути");
            put("constantly","постійно");
            put("goatee","цапина борідка");
            put("bald","лисина");
            put("straight","прямий");
            put("chin","підборіддя");
        }};

        Dictionary_Eng_Ukr Dict = new Dictionary_Eng_Ukr(Words);


        String A_T, Y_N;

        do {
            do {
                System.out.print("What do tou want: Add or Translate (a/t): ");
                A_T = scanner.nextLine();
            } while(!A_T.equals("a") && !A_T.equals("t"));

            //Add
            if(A_T.equals("a")) {
                System.out.print("Write a word/phrase on English: ");
                String toAddEng = scanner.nextLine();
                System.out.print("Write a translation on Ukrainian: ");
                String toAddUkr = scanner.nextLine();
                Dict.addToDictionary(toAddEng,toAddUkr);
            }
            //Translate
            if(A_T.equals("t")) {
                System.out.print("Write a word/phrase on English: ");   // exit is near the straight bald
                String toTranslate = scanner.nextLine();
                System.out.println("Переклад: " + Dict.getTranslation(toTranslate));
            }


            do {
                System.out.print("Do you want to continue (y/n): ");
                Y_N = scanner.nextLine();
            } while(!Y_N.equals("y") && !Y_N.equals("n"));
            System.out.println();

        } while(Y_N.equals("y"));

    }
}