package step3.worker.domain;

import step3.worker.domain.strategy.MovableStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> createCars(final List<String> carNames, final MovableStrategy movableStrategy) {
        return carNames.stream()
                .map(carName -> Car.of(carName, movableStrategy))
                .collect(Collectors.toList());
    }
}
