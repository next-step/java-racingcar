package step3;

import step3.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    public static List<Car> generate(String[] nameOfCars) {
        return Arrays.stream(nameOfCars)
            .map(Car::new)
            .collect(Collectors.toList());
    }

}
