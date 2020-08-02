package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;

public class MotorRace {

    private List<Driver> drivers;
    private int numberOfRepeats;
    private Dice dice;

    public MotorRace(int numberOfCars, int numberOfRepeats) {
        this.drivers = new ArrayList<>();
        this.numberOfRepeats = numberOfRepeats;
        this.dice = new Dice(0, 9);
        createTeam(numberOfCars);
    }

    private void createTeam(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            drivers.add(new Driver(new RacingCar()));
        }
    }

    public void game() {
        for (int i = 0; i < numberOfRepeats; i++) {
            for (Driver driver : drivers) {
                driver.drive(dice);
            }
            System.out.println("ended of " + (i + 1) + "\n");
        }
    }
}
