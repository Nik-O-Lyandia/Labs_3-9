package com.company;

public class PoliceCar extends Auto {
    String PoliceCardNumber;

    public PoliceCar(int id, int NumOfSeats, String mark, String PCN) {
        super(id, NumOfSeats, mark);
        this.PoliceCardNumber = PCN;
    }

    public void setPoliceCardNumber(String PCN) {
        this.PoliceCardNumber = PCN;
    }

    public String getPoliceCardNumber() {
        return(this.PoliceCardNumber);
    }

    @Override
    public <T extends Person> void TakeSeat(T t) throws Exception {
        if(t instanceof Policeman) {
            super.TakeSeat(t);
        }
        else
        {
            throw new Exception("The person " + t.getPersonId() + " can't ride this vehicle.");
        }
    }
}
