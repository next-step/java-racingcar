package service.impl;

import model.Car;
import service.WinnerStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleWinnerStrategy implements WinnerStrategy {

    private static final int DEFAULT_CAR_POSITION = 0;

    @Override
    public List<Car> pickWinner(List<Car> candidates) {
        Integer maxPosition = candidates.stream().map(Car::getCurrentPosition).max(Integer::compareTo).orElse(DEFAULT_CAR_POSITION);
        return candidates.stream().filter((car) -> car.getCurrentPosition() == maxPosition).collect(Collectors.toList());
    }
}
