package racingcar;

import racingcar.exception.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {

    private List<Car> cars;

    static Racing of(final int numOfCar) {
        return new Racing(numOfCar);
    }
    private Racing(final int numOfCar) {
        validateInput(numOfCar);
        createCars(numOfCar);
    }

    private void validateInput(final int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_ZERO);
        }
    }

    private void createCars(final int numOfCar) {
        cars = Stream.generate(Car::of)
                .limit(numOfCar)
                .collect(Collectors.toList());
    }
}
