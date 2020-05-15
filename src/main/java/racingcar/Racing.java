package racingcar;

import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private static final int MIN_NUM_OF_CARS = 0;

    private List<Car> cars;

    public static Racing of(final String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::of)
                .collect(Collectors.toList());
        return new Racing(cars);
    }

    private Racing(final List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(final List<Car> cars) {
        if (cars == null || cars.size() == MIN_NUM_OF_CARS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
        }
    }

    void run(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    List<Car> getCars() {
        return this.cars;
    }
}
