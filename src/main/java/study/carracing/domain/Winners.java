package study.carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public List<String> pickWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        winners.addAll(cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition(cars))
                .map(Car::getName)
                .collect(Collectors.toList())
        );

        return winners;
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
