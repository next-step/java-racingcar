package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {

    private List<Car> cars;

    static Racing of(final int numOfCar) {
        return new Racing(numOfCar);
    }
    private Racing(final int numOfCar) {
        createCars(numOfCar);
    }

    private void createCars(final int numOfCar) {
        cars = Stream.generate(Car::of)
                .limit(numOfCar)
                .collect(Collectors.toList());
    }
}
