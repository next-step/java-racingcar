package com.cspark.nextstep.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Driver {

    private final Function<Dice, Boolean> rule;
    private RacingCar racingCar;
    private List<Boolean> records;

    public Driver(Function<Dice, Boolean> rule) {
        this.rule = rule;
        this.records = new ArrayList<>();
        this.racingCar = new RacingCar();
    }

    public int drive(Dice dice) {
        records.add(rule.apply(dice));
        return racingCar.race(records);
    }

}
