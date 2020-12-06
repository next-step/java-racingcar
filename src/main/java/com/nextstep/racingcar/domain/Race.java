package com.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Race {
    private static final String DELIMITER = ",";
    private List<Car> cars = new ArrayList<>();

    public Race(List<CarName> carNames, Supplier<Integer> numberGenerator) {
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

    public String getWinnerNames() {
        Car winner = getWinner();
        return cars.stream()
                .filter(car -> car.equalsPosition(winner))
                .map(Car::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private Car getWinner() {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = winner.compareAndGet(car);
        }
        return winner;
    }
}
