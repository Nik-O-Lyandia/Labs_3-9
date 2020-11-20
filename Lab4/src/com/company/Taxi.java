package com.company;

public class Taxi extends Auto {
    String TaxiPhoneNum;

    public Taxi(int id, int NumOfSeats, String mark, String PhoneNum) {
        super(id, NumOfSeats, mark);
        this.TaxiPhoneNum = PhoneNum;
    }

    public void setTaxiPhoneNum(String PhoneNum) {
        this.TaxiPhoneNum = PhoneNum;
    }

    public String getTaxiPhoneNum() {
        return(this.TaxiPhoneNum);
    }
}
