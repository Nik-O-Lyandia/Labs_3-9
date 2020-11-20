package com.company;

public class Policeman extends Person {
    private int UniquePolicemanId;

    public Policeman(int id, int UPId) {
        super(id);
        this.UniquePolicemanId = UPId;
    }

    public void setUniquePolicemanId(int id) {
        this.UniquePolicemanId = id;
    }

    public int getUniquePolicemanId() {
        return(this.UniquePolicemanId);
    }
}
