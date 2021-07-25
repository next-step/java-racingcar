package step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {
    List<Car> createCarsBy(int numberOfCars) {
        return Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }
}
