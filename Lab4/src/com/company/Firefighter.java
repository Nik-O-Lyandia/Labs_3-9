package com.company;

public class Firefighter extends Person {
    private int UniqueFFId;

    public Firefighter(int id, int UFFId) {
        super(id);
        this.UniqueFFId = UFFId;
    }

    public void setUniqueFFId(int id) {
        this.UniqueFFId = id;
    }

    public int getUniqueFFId() {
        return(this.UniqueFFId);
    }
}
