package com.company;

public class Person {
    private int PersonId;
    private int SitNum;

    public Person(int id) {
        this.PersonId = id;
    }

    public void setPersonId(int id) {
        this.PersonId = id;
    }

    public void setSitNum(int SitNum) {
        this.SitNum = SitNum;
    }

    public int getPersonId() {
        return(this.PersonId);
    }

    public int getSitNum() {
        return(this.SitNum);
    }

}
