package com.cheolhyeonpark.step3;

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
        cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    private boolean isMovable() {
        return dice.rollDice() >= MINIMUM_MOVABLE_DICE_NUMBER;
    }
}
