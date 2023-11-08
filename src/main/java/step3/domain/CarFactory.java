package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {

    public static List<Car> createCars(final int carCount) {
        return Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }
}
