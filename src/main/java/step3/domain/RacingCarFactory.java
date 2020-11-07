package step3.domain;

import step3.domain.strategy.MovableStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {
    public static List<RacingCar> createCars(final List<String> carNames, final MovableStrategy movableStrategy) {
        return carNames.stream()
                .map(carName -> RacingCar.of(carName, movableStrategy))
                .collect(Collectors.toList());
    }
}
