package com.company;

public class Auto extends Vehicle {
    private String AutoMark;

    public Auto(int id, int NumOfSeats, String mark) {
        super(id, NumOfSeats);
        this.AutoMark = mark;
    }

    public void setAutoMark(String mark) {
        this.AutoMark = mark;
    }

    public String getAutoMark() {
        return(this.AutoMark);
    }
}
