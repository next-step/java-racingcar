package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {
    public static List<RacingCar> createCars(final List<String> nameOfCars, final MovableStrategy movableStrategy) {
        return nameOfCars.stream()
                .map(carName -> new RacingCar(carName, movableStrategy))
                .collect(Collectors.toList());
    }
}
