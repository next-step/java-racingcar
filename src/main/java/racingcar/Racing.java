package racingcar;

import racingcar.exception.ErrorMessage;
import racingcar.moving.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {

    private static final int MIN_NUM_OF_CARS = 0;

    private List<Car> cars;

    static Racing of(final int numOfCar) {
        return new Racing(numOfCar);
    }
    
    private Racing(final int numOfCar) {
        validateInput(numOfCar);
        createCars(numOfCar);
    }

    private void validateInput(final int numOfCar) {
        if (numOfCar <= MIN_NUM_OF_CARS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PARAMETER);
        }
    }

    private void createCars(final int numOfCar) {
        cars = Stream.generate(Car::newInstance)
                .limit(numOfCar)
                .collect(Collectors.toList());
    }

    void run(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    List<Car> getCars() {
        return this.cars;
    }
}
