package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarFactory {
    public static List<RacingCar> createCars(final int numberOfCar, final MovableStrategy movableStrategy) {
        return IntStream.range(0, numberOfCar)
                .mapToObj(i -> new RacingCar(String.valueOf(i), movableStrategy))
                .collect(Collectors.toList());
    }
}
