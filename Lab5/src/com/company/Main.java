package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        Scanner scanner = new Scanner(System.in);
        String N_C;

        try {
            System.out.println("Task1:\t" + task1.FindMaxLine("111.txt"));
        }
        catch (IOException e) {
            System.out.println("Problem in tasks1: " + e);
        }

        try {
            task3.writeFile("333.txt", 'r');
            String[] strs = task3.readFile("333.txt", 'r');
            System.out.println("Task3:");
            for (String s : strs)
                System.out.println("\t" + s);
        }
        catch (IOException e) {
            System.out.println("Problem in tasks3: " + e);
        }

        try {
            System.out.println("Task4:");
            ArrayList<TagGroup> tagGroups = task4.findTags("https://www.java-forums.org/forum.php");
            do {
                System.out.print("Sort by Name or by Count (n/c): ");
                N_C = scanner.nextLine();
            } while(!N_C.equals("n") && !N_C.equals("c"));

                //Sort by NAME
            if(N_C.equals("n")) {
                tagGroups.sort(new Comparator<TagGroup>() {
                    @Override
                    public int compare(TagGroup o1, TagGroup o2) {
                        TagGroup tagGroups1 = (TagGroup)o1;
                        TagGroup tagGroups2 = (TagGroup)o2;
                        if(tagGroups1.getName().compareTo(tagGroups2.getName()) > 0) return 1;
                        if(tagGroups1.getName().compareTo(tagGroups2.getName()) < 0) return -1;
                        return 0;
                    }
                });
            }
                //Sort by COUNT
            if(N_C.equals("c")) {
                tagGroups.sort(new Comparator<TagGroup>() {
                    @Override
                    public int compare(TagGroup o1, TagGroup o2) {
                        TagGroup tagGroups1 = (TagGroup)o1;
                        TagGroup tagGroups2 = (TagGroup)o2;
                        if(tagGroups1.getCount() > tagGroups2.getCount()) return 1;
                        if(tagGroups1.getCount() < tagGroups2.getCount()) return -1;
                        return 0;
                    }
                });
            }

            System.out.println("_________________________________________");
            System.out.printf("%-1s %-25s %-1s %-9s %-1s", "|", "--NAME--", "|", "--COUNT--", "|");
            System.out.println();
            for(int i = 0; i < tagGroups.size(); i++) {
                System.out.printf("%-1s %-25s %-1s %-9s %-1s", "|", tagGroups.get(i).getName(), "|", tagGroups.get(i).getCount(), "|");
                System.out.println();
            }
            System.out.println("-----------------------------------------");
        }
        catch (IOException e) {
            System.out.println("Problem in tasks4: " + e);
        }

    }
}
