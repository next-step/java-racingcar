package racingcar.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CarFactory {
    public static Cars initCars(String carsName) {
        return new Cars(Arrays.stream(carsName.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));
    }
}
