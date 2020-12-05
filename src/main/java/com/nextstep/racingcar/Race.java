package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Race {
    private int moveLimit;
    private List<Car> cars = new ArrayList<>();

    public Race(List<CarName> carNames, int moveLimit, Supplier<Integer> numberGenerator) {
        this.moveLimit = moveLimit;
        for (CarName carName : carNames) {
            cars.add(new Car(carName, numberGenerator));
        }
    }

    public List<Car> moveAndGet() {
        for (Car car : cars) {
            car.tryMove();
        }
        return cars;
    }

    public boolean isNotFinished() {
        boolean isNotFinished = true;
        for (Car car : cars) {
            isNotFinished = isNotFinished && car.isNotFinished(moveLimit);
        }
        return isNotFinished;
    }

    public String getFinishedCarNames(){
        return cars.stream()
                .filter(car -> car.isFinished(moveLimit))
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}
