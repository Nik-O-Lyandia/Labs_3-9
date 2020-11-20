package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Road road1 = new Road();
        Bus bus = new Bus(1, 7, "Audi");
        PoliceCar pc = new PoliceCar(2, 3, "Shkoda", "DD1111");

        road1.addCarToRoad(bus);
        road1.addCarToRoad(pc);
        try {
            bus.TakeSeat(new Person(1));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(2));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(3));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(4));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Policeman(5, 1));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(6));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(7));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            bus.TakeSeat(new Person(8));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            pc.TakeSeat(new Policeman(9, 1));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            pc.TakeSeat(new Person(10));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            pc.TakeSeat(new Firefighter(1, 1));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        bus.DropOffPassenger(5);
        bus.DropOffPassenger(6);

        ArrayList<Bus> buses = new ArrayList<>();

        buses.add(bus);
        try {
            Bus bus1 = new Bus(2, 10, "Audi");
            bus1.TakeSeat(new Firefighter(1, 1));
            bus1.TakeSeat(new Person(2));
            bus1.TakeSeat(new Person(3));
            bus1.TakeSeat(new Person(4));
            bus1.TakeSeat(new Person(5));
            bus1.TakeSeat(new Person(6));
            bus1.TakeSeat(new Person(7));
            bus1.TakeSeat(new Person(8));
            bus1.TakeSeat(new Person(9));
            bus1.TakeSeat(new Person(10));
            buses.add(bus1);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            Bus bus2 = new Bus(3, 3, "Audi");
            bus2.TakeSeat(new Firefighter(1, 1));
            bus2.TakeSeat(new Firefighter(2, 2));
            bus2.TakeSeat(new Firefighter(3, 3));
            buses.add(bus2);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        try {
            road1.addCarListToRoad(buses);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Passengers on road1: " + road1.getCountOfHumans());

        System.out.println(bus.getOccupiedSeats());
        System.out.println(pc.getOccupiedSeats());
    }
}
