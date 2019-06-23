package com.mommoo.step2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarWinnerComputer {
    private static final int NONE_OF_WINNER_CAR_POSITION = 0;

    private final List<String> winnerCarNameList;

    public CarWinnerComputer(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        this.winnerCarNameList = pickCarNames(cars, maxPosition);
    }

    private static int getMaxPosition(List<Car> carList) {
        return carList.stream()
                      .mapToInt(Car::getPosition)
                      .max()
                      .orElse(NONE_OF_WINNER_CAR_POSITION);
    }

    private static List<String> pickCarNames(List<Car> cars, int position) {
        return cars.stream()
                   .filter(car -> car.getPosition() > NONE_OF_WINNER_CAR_POSITION)
                   .filter(car -> car.getPosition() == position)
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public boolean isWinnerNotExist() {
        return winnerCarNameList.size() == 0;
    }

    public List<String> getWinnerCarNameList() {
        return Collections.unmodifiableList(winnerCarNameList);
    }
}
