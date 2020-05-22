package com.cheolhyeonpark.step4.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> getWinners() {
        int max = cars.stream().mapToInt(Car::getPosition).max()
                .orElseThrow(() -> new RuntimeException("Couldn't find max position."));
        return cars.stream().filter(car -> car.getPosition() == max).collect(Collectors.toList());
    }
}
