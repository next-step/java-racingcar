package racingcar.domain;

import java.util.stream.Stream;

public class CarFactory {
    private static final String DELIMITER = ",";

    private CarFactory() {
    }

    public static Cars createCars(String carNames) {
        Cars cars = new Cars();

        Stream.of(carNames.split(DELIMITER))
                .map(Car::new)
                .forEach(cars::add);

        return cars;
    }
}
