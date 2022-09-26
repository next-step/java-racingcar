package service.impl;

import model.Car;
import model.CarPosition;
import service.WinnerStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleWinnerStrategy implements WinnerStrategy {

    @Override
    public List<Car> pickWinner(List<Car> candidates) {
        CarPosition maxPosition = getMaxPosition(candidates);
        return candidates.stream().filter((car) -> car.isSamePosition(maxPosition)).collect(Collectors.toList());
    }

    private CarPosition getMaxPosition(List<Car> candidates) {
        return candidates.stream().map(Car::getCarPosition).max(CarPosition::compareTo).orElse(CarPosition.ZERO);
    }
}
