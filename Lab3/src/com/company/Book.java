package com.company;

import java.io.Serializable;

public class Book implements Serializable {
    private String Name;
    private String Author;
    private String PublishingHouse;
    private int PublishingDate;
    private int PageCount;
    private float Price;

    public Book(String name, String author, String publishingHouse, int publishingDate, int pageCount, float price) {
        this.Name = name;
        this.Author = author;
        this.PublishingHouse = publishingHouse;
        this.PublishingDate = publishingDate;
        this.PageCount = pageCount;
        this.Price = price;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.PublishingHouse = publishingHouse;
    }

    public void setPublishingDate(int publishingDate) {
        this.PublishingDate = publishingDate;
    }

    public void setPageCount(int pageCount) {
        this.PageCount = pageCount;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public String getName() {
        return this.Name;
    }

    public String getAuthor() {
        return this.Author;
    }

    public String getPublishingHouse() {
        return this.PublishingHouse;
    }

    public int getPublishingDate() {
        return this.PublishingDate;
    }

    public int getPageCount() {
        return this.PageCount;
    }

    public float getPrice() {
        return this.Price;
    }
}
