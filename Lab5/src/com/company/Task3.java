package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    File f;
    FileInputStream fis;
    FileOutputStream fos;
    FilterReader fr;
    FilterWriter fw;

    public void writeFile(String filePath, char encryptSymbol) throws IOException{
        f = new File(filePath);
        fos = new FileOutputStream(f);
        String[] s = new String[3];
        s[0] = "123654789";
        s[1] = "SoS123";
        s[2] = "Good Morning!";
        char[] c;

        for(int j = 0; j < s.length; j++) {
            c = new char[s[j].length()];
            for(int i = 0; i < s[j].length(); i++) {
                s[j].getChars(0, s[j].length(), c, 0);
                fos.write(c[i] + (int) encryptSymbol);
            }
            fos.write('\n' + (int)encryptSymbol);
        }
        fos.close();
    }

    public String[] readFile(String filePath, char decryptSymbol) throws IOException{
        f = new File(filePath);
        fis = new FileInputStream(f);
        int c;
        String s = "";
        String[] strs;
        ArrayList<Character> chars = new ArrayList<>();

        try {
            while ((c = fis.read()) != -1) {
                chars.add((char) (c - (int) decryptSymbol));
            }
        }
        catch (EOFException e) {
            System.out.println(e);
        }

        for(int i = 0; i < chars.size(); i++) {
            s = s.concat(chars.get(i).toString());
        }
        strs = s.split("\n");

        fis.close();
        return strs;
    }
}
