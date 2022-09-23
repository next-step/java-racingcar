package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {
    public static final String DELIMITER = ",";

    private CarFactory() {
    }

    public static Cars createCars(String carNames) {
        List<Car> cars = Stream.of(splitName(carNames))
                .map(String::strip)
                .map(Car::new)
                .collect(Collectors.toList());

        return Cars.of(cars);
    }

    public static String[] splitName(String carNames) {
        return carNames.split(DELIMITER);
    }
}
