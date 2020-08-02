package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private RacingCar racingCar;
    private List<Boolean> records;

    public Driver(RacingCar racingCar) {
        this.records = new ArrayList<>();
        this.racingCar = racingCar;
    }

    public int drive(Dice dice) {
        records.add(dice.cast() > 3);
        return racingCar.race(records);
    }

}
