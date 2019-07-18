package com.mommoo.step2.domain;

import com.mommoo.step2.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarWinnerComputer {
    private static final int NONE_OF_WINNER_CAR_POSITION = 0;

    private final List<String> winnerCarNames;

    public CarWinnerComputer(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        this.winnerCarNames = pickCarNames(cars, maxPosition);
    }

    private static int getMaxPosition(List<Car> carList) {
        return carList.stream()
                      .mapToInt(Car::getPosition)
                      .max()
                      .orElse(NONE_OF_WINNER_CAR_POSITION);
    }

    private static List<String> pickCarNames(List<Car> cars, int position) {
        return cars.stream()
                   .filter(car -> car.isPositionAt(position))
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public boolean isWinnerNotExist() {
        return winnerCarNames.isEmpty();
    }

    public List<String> getWinnerCarNames() {
        return Collections.unmodifiableList(winnerCarNames);
    }
}
