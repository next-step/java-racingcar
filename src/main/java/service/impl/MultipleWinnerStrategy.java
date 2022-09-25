package service.impl;

import model.Car;
import service.WinnerStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleWinnerStrategy implements WinnerStrategy {

    private static final int DEFAULT_CAR_POSITION = 0;

    @Override
    public List<Car> pickWinner(List<Car> candidates) {
        Integer maxPosition = getMaxPosition(candidates);
        return candidates.stream().filter((car) -> car.isSamePosition(maxPosition)).collect(Collectors.toList());
    }

    private Integer getMaxPosition(List<Car> candidates) {
        return candidates.stream().map(Car::getCurrentPosition).max(Integer::compareTo).orElse(DEFAULT_CAR_POSITION);
    }
}
