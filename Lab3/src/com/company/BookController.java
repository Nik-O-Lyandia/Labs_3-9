package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BookController {
    private Book[] bookModel;
    private BookView bookView;

    public BookController(Book[] model, BookView view) {
        this.bookModel = model;
        this.bookView = view;
    }

    public void setBookName(String name, int BookNum) {
        bookModel[BookNum].setName(name);
    }

    public void setBookAuthor(String author, int BookNum) {
        bookModel[BookNum].setAuthor(author);
    }

    public void setBookPublisherHouse(String publishingHouse, int BookNum) {
        bookModel[BookNum].setPublishingHouse(publishingHouse);
    }

    public void setBookPublisherDate(int publishingDate, int BookNum) {
        bookModel[BookNum].setPublishingDate(publishingDate);
    }

    public void setBookPageCount(int pageCount, int BookNum) {
        bookModel[BookNum].setPageCount(pageCount);
    }

    public void setBookPrice(float price, int BookNum) {
        bookModel[BookNum].setPrice(price);
    }

    public String getBookName(int BookNum) {
        return bookModel[BookNum].getName();
    }

    public String getBookAuthor(int BookNum) {
        return bookModel[BookNum].getAuthor();
    }

    public String getBookPublishingHouse(int BookNum) {
        return bookModel[BookNum].getPublishingHouse();
    }

    public int getBookPublishingDate(int BookNum) {
        return bookModel[BookNum].getPublishingDate();
    }

    public int getBookPageCount(int BookNum) {
        return bookModel[BookNum].getPageCount();
    }

    public float getBookPrice(int BookNum) {
        return bookModel[BookNum].getPrice();
    }

    public void updateBookView(Book[] Library) {
        bookView.viewAllBooks(Library);
    }

    public void sortByPublishingHouse(Book[] Library) {
        Arrays.sort(Library, new BookComparatorByPublishingHouse());
        bookView.viewAllBooks(Library);
    }

    public void getBooksByAuthor(Book[] Library, String author) {
        for(int i = 0; i < Library.length; i++) {
            if(Library[i].getAuthor().equals(author)) {
                bookView.printBookDetails(bookModel[i].getName(), bookModel[i].getAuthor(), bookModel[i].getPublishingHouse(), bookModel[i].getPublishingDate(),
                        bookModel[i].getPageCount(), bookModel[i].getPrice(), i);
            }
        }
    }

    public void getBooksByPublishingHouse(Book[] Library, String publishingHouse) {
        for(int i = 0; i < Library.length; i++) {
            if(Library[i].getPublishingHouse().equals(publishingHouse)) {
                bookView.printBookDetails(bookModel[i].getName(), bookModel[i].getAuthor(), bookModel[i].getPublishingHouse(), bookModel[i].getPublishingDate(),
                        bookModel[i].getPageCount(), bookModel[i].getPrice(), i);
            }
        }
    }

    public void getBooksByPublishingDate(Book[] Library, int publishingDate) {
        for(int i = 0; i < Library.length; i++) {
            if(Library[i].getPublishingDate() > publishingDate) {
                bookView.printBookDetails(bookModel[i].getName(), bookModel[i].getAuthor(), bookModel[i].getPublishingHouse(), bookModel[i].getPublishingDate(),
                        bookModel[i].getPageCount(), bookModel[i].getPrice(), i);
            }
        }
    }

    public void saveAllBooks(Book[] Library, String filePath) {
        try {
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for(int i = 0; i < Library.length; i++) {
                oos.writeObject(this.bookModel[i]);
            }
            fos.close();
            oos.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void loadLibraryFromFile(String filePath) throws Exception{
        Book book;
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        book = (Book) ois.readObject();
        this.bookModel[0] = book;
        int i = 1;
        try {
            while(fis.available() > 0) {
                book = (Book) ois.readObject();
                this.bookModel[i++] = book;
            }
        }
        catch (EOFException e) {
            System.out.println("BookController::Line 133: " + e);
        }
        catch (NullPointerException ex) {
            System.out.println("BookController::Line 136: " + ex);
        }

        fis.close();
        ois.close();

    }
}

