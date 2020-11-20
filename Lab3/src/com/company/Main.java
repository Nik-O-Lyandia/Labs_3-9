package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Book[] models = retrieveBooksFromDatabase();//new Book[20];
        BookView view = new BookView();
        BookController controller = new BookController(models, view);

        Book[] modelsLoaded = new Book[15];
        BookView viewLoaded = new BookView();
        BookController controllerLoaded = new BookController(modelsLoaded, viewLoaded);

        Scanner scanner = new Scanner(System.in);
        String Y_N, inputData;
        int choice = 0;
        do {
            do {
                choice = 0;
                System.out.println("Please choose one from these options: \n\t1) Pick all books by specified author; \n\t2) Pick all books by specified publishing house; " +
                        "\n\t3) Pick all books which was published after specified year; \n\t4) Pick all books and order them by publishing houses;" +
                        "\n\t5) Add all books to the file; \n\t6) Load all books from file.");
                choice = Integer.valueOf(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Please enter an author name: ");
                        inputData = scanner.nextLine();
                        System.out.println();
                        controller.getBooksByAuthor(models, inputData); //Джоан Роулінг
                        break;
                    case 2:
                        System.out.print("Please enter a publishing house name: ");
                        inputData = scanner.nextLine();
                        System.out.println();
                        controller.getBooksByPublishingHouse(models, inputData); //А-ба-ба-га-ла-ма-га
                        break;
                    case 3:
                        System.out.print("Please enter year: ");
                        inputData = scanner.nextLine();
                        System.out.println();
                        controller.getBooksByPublishingDate(models, Integer.valueOf(inputData)); //2017
                        break;
                    case 4:
                        controller.sortByPublishingHouse(models);
                        break;
                    case 5:
                        controller.saveAllBooks(models, "savedBooks.txt");
                        break;
                    case 6:
                        try {
                            controllerLoaded.loadLibraryFromFile("savedBooks.txt");
                            controllerLoaded.updateBookView(modelsLoaded);
                        }
                        catch (Exception e) {
                            System.out.println("Main::Line 58: " + e);
                        }
                        break;
                }
            } while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);


            System.out.println();
            do {
                System.out.print("Do you want to continue (y/n): ");
                Y_N = scanner.nextLine();
            } while(!Y_N.equals("y") && !Y_N.equals("n"));
        } while(Y_N.equals("y"));

        //controller.updateBookView(1);
    }

    private static Book[] retrieveBooksFromDatabase() {
        Book[] Library = {
                new Book("Тореадори з Васюківки", "Всеволод Нестайко", "А-ба-ба-га-ла-ма-га", 2013, 544, (float)140.0),
                new Book("Триста поезій", "Ліна Костенко", "А-ба-ба-га-ла-ма-га", 2019, 416, (float)140.0),
                new Book("Англійська мова. Граматика. Збірник вправ", "Юрій Голіцинський", "Арій", 2017, 544, (float)80.0),
                new Book("Гаррі Поттер і філософський камінь", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2017, 320, (float)160.0),
                new Book("Гаррі Поттер i Орден Фенікса", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2017, 816, (float)180.0),
                new Book("Казки Барда Бідла", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2015, 128, (float)120.0),
                new Book("Кафе на краю світу", "Джон П. Стрелекі", "Vivat", 2019, 128, (float)125.0),
                new Book("Гаррі Поттер і Напівкровний Принц", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2017, 576, (float)180.0),
                new Book("Чарлі і шоколадна фабрика", "Роальд Дал", "А-ба-ба-га-ла-ма-га", 2009, 240, (float)140.0),
                new Book("The One. Единственный", "Джон Маррс", "Форс", 2020, 416, (float)204.0),
                new Book("Ведмеже місто", "Фредрік Бакман", "#книголав", 2019, 432, (float)250.0),
                new Book("Дневник книготорговца", "Шон Байтелл", "Азбука", 2018, 384, (float)200.0),
                new Book("Идиот", "Федір Достоєвський", "Азбука", 2012, 640, (float)60.0),
                new Book("Сила", "Наомі Алдерман", "#книголав", 2020, 376, (float)250.0),
                new Book("Скандинавська міфологія", "Ніл Ґейман", "КМ-БУКС", 2017, 256, (float)140.0),
        };
        return Library;
    }
}
