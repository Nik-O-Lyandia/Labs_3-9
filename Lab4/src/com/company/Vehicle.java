package com.company;

import java.util.ArrayList;

public class Vehicle {
    private int VehicleId;
    private int NumOfSeats;
    private int[][] OccupiedSeats;

    public Vehicle(int id, int NumOfSeats) {
        this.VehicleId = id;
        this.NumOfSeats = NumOfSeats;
        this.OccupiedSeats = new int[NumOfSeats][2];
        for(int i : OccupiedSeats[0]) {
            i = 0;
        }
    }

    public void setVehicleId(int id) {
        this.VehicleId = id;
    }

    public int getVehicleId() {
        return(this.VehicleId);
    }

    public <T extends Person> void TakeSeat(T t) throws Exception {
        int i = 0;
        try {
            while (true) {
                if(OccupiedSeats[i][0] == 0) {
                    OccupiedSeats[i][0] = 1;
                    OccupiedSeats[i][1] = t.getPersonId();
                    t.setSitNum(i);
                    //System.out.println("TakeSeat: " + (i + 1) + " by person " + OccupiedSeats[i][1]);
                    break;
                }
                i++;
            }
        }
        catch (Exception ex) {
            throw ex;
        }

    }

    public void DropOffPassenger(int PassengerId) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        try {
            while(true) {
                if(OccupiedSeats[i][1] == PassengerId) {
                    OccupiedSeats[i][0] = OccupiedSeats[i][1] = 0;
                    break;
                }
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The passenger on number " + PassengerId + " isn't on this vehicle.");
            throw e;
        }

    }

    public ArrayList<Integer> getOccupiedSeats() {
        ArrayList<Integer> OS = new ArrayList<>();

        for(int i = 0; i < OccupiedSeats.length; i++) {
            if(OccupiedSeats[i][0] == 1) {
                OS.add(i+1);
            }
        }
        return OS;
    }
}
