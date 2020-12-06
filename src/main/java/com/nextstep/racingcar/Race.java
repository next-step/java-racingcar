package com.nextstep.racingcar;

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
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.equalsPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
