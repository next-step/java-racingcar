package racing.factories;

import racing.models.Car;
import racing.models.Cars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CarsFactory {
    public static Cars createFrom(String[] names) {
        return new Cars(Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }
}
