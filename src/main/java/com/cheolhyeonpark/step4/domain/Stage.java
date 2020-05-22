package com.cheolhyeonpark.step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Stage {

    private final MovingStrategy movingStrategy;
    private final List<Car> cars;

    public Stage(MovingStrategy movingStrategy, List<Car> cars) {
        this.movingStrategy = movingStrategy;
        this.cars = cars;
    }

    public void run() {
        cars.forEach(car -> car.move(movingStrategy.isMovable()));
    }

    public List<Car> getStageResult() {
        return this.cars;
    }

    public List<Car> getWinners() {
        int max = cars.stream().mapToInt(Car::getPosition).max()
                .orElseThrow(() -> new RuntimeException("Couldn't find max position."));
        return cars.stream().filter(car -> car.isSamePosition(max)).collect(Collectors.toList());
    }
}
