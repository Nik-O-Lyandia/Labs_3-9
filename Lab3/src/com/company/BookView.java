package com.company;


public class BookView {
    public void printBookDetails(String Name, String Author, String PublishingHouse, int PublishingDate, int PageCount, float Price, int BookNum) {
        System.out.println("\tBook " + (BookNum + 1) + ": ");
        System.out.println("Name: " + Name);
        System.out.println("Author: " + Author);
        System.out.println("PublishingHouse: " + PublishingHouse);
        System.out.println("PublishingDate: " + PublishingDate);
        System.out.println("PageCount: " + PageCount);
        System.out.println("Price: " + Price);
    }

    public void viewAllBooks(Book[] Library) {
        System.out.printf("%-50s %-25s %-25s %-25s %-15s %-10s", "--Name--", "--Author--", "--Publishing House--", "--Publishing Date--", "--Page count--", "--Price--");
        System.out.println();
        for(Book b : Library) {
            System.out.printf("%-50s %-25s %-25s %-25s %-15s %-10s", b.getName(), b.getAuthor(), b.getPublishingHouse(), b.getPublishingDate(), b.getPageCount(), b.getPrice());
            System.out.println();
        }
    }
}
