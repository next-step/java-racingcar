package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<String> pickNamesOfWinners(List<Car> cars) {
        int MaxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == MaxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}