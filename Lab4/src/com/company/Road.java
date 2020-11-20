package com.company;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for(Vehicle v : this.carsInRoad) {
            count += v.getOccupiedSeats().size();
        }
        return count;
    }

    public <T extends Vehicle> void addCarToRoad(T car) {
        try {
            carsInRoad.add(car);
        }
        catch (Exception e) {
            System.out.println("Exception in 'addCarToRoad' - " + e);
        }
    }

    public void addCarListToRoad(ArrayList<? extends Vehicle> carList) throws Exception{
        carsInRoad.addAll(carList);
    }
}
