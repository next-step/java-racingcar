package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private List<Boolean> records;

    private Dice generator;
    private RacingCar racingCar;

    public Driver(Dice generator, RacingCar racingCar) {
        this.records = new ArrayList<>();
        this.generator = generator;
        this.racingCar = racingCar;
    }

    public int drive() {
        records.add(generator.cast() > 3);
        return racingCar.race(records);
    }
}
