package com.company;

public class Bus extends Vehicle {
    private String BusMark;

    public Bus(int id, int NumOfSeats, String mark) {
        super(id, NumOfSeats);
        this.BusMark = mark;
    }

    public void setBusMark(String mark) {
        this.BusMark = mark;
    }

    public String getBusMark() {
        return(this.BusMark);
    }
}
