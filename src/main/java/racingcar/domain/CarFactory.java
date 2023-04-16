package racingcar.domain;

import java.util.stream.Stream;

public class CarFactory {

    static public Car[] createCars(int numberOfCars) {
        return Stream.generate(Car::new).limit(numberOfCars).toArray(Car[]::new);
    }
}
