package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Road road1 = new Road();
    Bus bus = new Bus(1, 7, "Audi");
    Taxi taxi = new Taxi(2, 4, "Audi", "0993333333");
    PoliceCar pc = new PoliceCar(3, 3, "Shkoda", "DD1111");
    FireTruck ft = new FireTruck(4, 5, "BMW", 1500);

    @Test
    public void testAddToBusPerson() {
        assertDoesNotThrow(
                () -> bus.TakeSeat(new Person(1)),
                "Error"
        );

    }

    @Test
    public void testAddToBusPoliceman() {
        assertDoesNotThrow(
                () -> bus.TakeSeat(new Policeman(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToBusFirefighter() {
        assertDoesNotThrow(
                () -> bus.TakeSeat(new Firefighter(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToTaxiPerson() {
        assertDoesNotThrow(
                () -> taxi.TakeSeat(new Person(1)),
                "Error"
        );
    }

    @Test
    public void testAddToTaxiPoliceman() {
        assertDoesNotThrow(
                () -> taxi.TakeSeat(new Policeman(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToTaxiFirefighter() {
        assertDoesNotThrow(
                () -> taxi.TakeSeat(new Firefighter(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToPoliceCarPerson() {
        assertThrows( Exception.class,
                () -> pc.TakeSeat(new Person(1)),
                "Error"
        );
    }

    @Test
    public void testAddToPoliceCarPoliceman() {
        assertDoesNotThrow(
                () -> pc.TakeSeat(new Policeman(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToPoliceCarFirefighter() {
        assertThrows( Exception.class,
                () -> pc.TakeSeat(new Firefighter(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToFireTruckPerson() {
        assertThrows( Exception.class,
                () -> ft.TakeSeat(new Person(1)),
                "Error"
        );
    }

    @Test
    public void testAddToFireTruckPoliceman() {
        assertThrows( Exception.class,
                () -> ft.TakeSeat(new Policeman(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToFireTruckFirefighter() {
        assertDoesNotThrow(
                () -> ft.TakeSeat(new Firefighter(1, 1)),
                "Error"
        );
    }

    @Test
    public void testAddToBusOverflow() {
        assertThrows( ArrayIndexOutOfBoundsException.class,
                () -> {
                    bus.TakeSeat(new Person(1));
                    bus.TakeSeat(new Person(2));
                    bus.TakeSeat(new Person(3));
                    bus.TakeSeat(new Person(4));
                    bus.TakeSeat(new Person(5));
                    bus.TakeSeat(new Person(6));
                    bus.TakeSeat(new Person(7));
                    bus.TakeSeat(new Person(8));
                },
                "Error"
        );
    }

    @Test
    public void testDropPassengers() {
        assertDoesNotThrow(
                () -> {
                    bus.TakeSeat(new Person(1));
                    bus.TakeSeat(new Person(2));
                    bus.TakeSeat(new Person(3));
                    bus.TakeSeat(new Person(4));
                    bus.TakeSeat(new Person(5));
                    bus.TakeSeat(new Person(6));
                    bus.TakeSeat(new Person(7));

                    bus.DropOffPassenger(1);
                    bus.DropOffPassenger(3);
                    bus.DropOffPassenger(5);
                    //System.out.println(bus.getOccupiedSeats());
                },
                "Error"
        );
    }

    @Test
    public void testDropNonExistentPassenger() {
        assertThrows( ArrayIndexOutOfBoundsException.class,
                () -> {
                    bus.TakeSeat(new Person(1));
                    bus.DropOffPassenger(3);
                },
                "Error"
        );
    }
}