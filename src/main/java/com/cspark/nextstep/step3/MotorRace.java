package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MotorRace {
    private final Function<Dice, Boolean> rule = (d) -> d.cast() > 3;

    private List<Driver> drivers;
    private int numberOfRepeats;
    private Dice dice;

    public MotorRace(int numberOfCars, int numberOfRepeats) {
        this.drivers = createTeam(numberOfCars);
        this.numberOfRepeats = numberOfRepeats;
        this.dice = new Dice(0, 9);
    }

    private List<Driver> createTeam(int numberOfCars) {
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            drivers.add(new Driver(rule));
        }

        return drivers;
    }

    public void game() {
        for (int i = 0; i < numberOfRepeats; i++) {
            lap();
        }
    }

    private void lap() {
        for (Driver driver : drivers) {
            driver.drive(dice);
        }
    }

}
