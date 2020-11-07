package step3.domain;

import step3.domain.strategy.MovableStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(final List<String> carNames, final MovableStrategy movableStrategy) {
        return carNames.stream()
                .map(carName -> Car.of(carName, movableStrategy))
                .collect(Collectors.toList());
    }
}
