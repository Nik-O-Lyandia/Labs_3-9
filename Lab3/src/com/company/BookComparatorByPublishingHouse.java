package com.company;

import java.util.Comparator;

public class BookComparatorByPublishingHouse implements Comparator {
    public int compare(Object o1, Object o2) {
        Book book1 = (Book)o1;
        Book book2 = (Book)o2;
        if(book1.getPublishingHouse().compareTo(book2.getPublishingHouse()) > 0) return 1;
        if(book1.getPublishingHouse().compareTo(book2.getPublishingHouse()) < 0) return -1;
        return 0;
    }
}

