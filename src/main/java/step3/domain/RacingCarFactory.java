package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarFactory {
    public static List<RacingCar> createCars(final int numberOfCar) {
        return IntStream.range(0, numberOfCar)
                .mapToObj(RacingCar::new)
                .collect(Collectors.toList());
    }
}
