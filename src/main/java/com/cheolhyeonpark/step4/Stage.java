package com.cheolhyeonpark.step4;

import java.util.List;

public class Stage {

    public static final int MINIMUM_MOVABLE_DICE_NUMBER = 4;

    private final Dice dice;
    private final List<Car> cars;

    public Stage(Dice dice, List<Car> cars) {
        this.dice = dice;
        this.cars = cars;
    }

    public void run() {
        cars.forEach(car -> car.move(isMovable()));
    }

    private boolean isMovable() {
        return dice.rollDice() >= MINIMUM_MOVABLE_DICE_NUMBER;
    }

    public List<Car> getStageResult() {
        return this.cars;
    }
}
