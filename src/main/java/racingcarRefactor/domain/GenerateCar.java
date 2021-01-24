package racingcarRefactor.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateCar {
    public static List<Car> ofCars(String inputNames) {
        return Arrays
                .stream(inputNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
