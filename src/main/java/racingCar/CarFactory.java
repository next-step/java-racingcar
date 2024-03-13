package racingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarFactory {
    public static List<RacingCar> createCars(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
            .mapToObj(i -> new RacingCar())
            .collect(Collectors.toList());
    }
}
