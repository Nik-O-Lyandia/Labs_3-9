package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    File file ;
    FileReader fr ;
    BufferedReader br ;

    public String FindMaxLine(String filePath) throws IOException {
        String line, maxLine;
        int maxCount = 0;
        file = new File(filePath);
        fr = new FileReader(file);
        br = new BufferedReader(fr);

        line = br.readLine();
        maxLine = line;
        while (line != null) {
            String[] strs = line.split(" ");
            if(strs.length > maxCount) {
                maxCount = strs.length;
                maxLine = line;
            }
            line = br.readLine();
        }


        return maxLine;
    }
}
