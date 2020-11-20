package com.company;

public class FireTruck extends Auto {
    float WaterValue;

    public FireTruck(int id, int NumOfSeats, String mark, float WV) {
        super(id, NumOfSeats, mark);
        this.WaterValue = WV;
    }

    public void setWaterValue(float WV) {
        this.WaterValue = WV;
    }

    public float getWaterValue() {
        return(this.WaterValue);
    }

    @Override
    public <T extends Person> void TakeSeat(T t) throws Exception {
        if(t instanceof Firefighter) {
            super.TakeSeat(t);
        }
        else
        {
            throw new Exception("The person " + t.getPersonId() + " can't ride this vehicle.");
        }
    }
}
