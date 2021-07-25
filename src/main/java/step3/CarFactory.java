package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {

    List<Car> createCars(int numberOfCars) {
        return Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

}
