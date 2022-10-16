package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private static void validateCars(final List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage("cars cannot be null"));
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage("cars cannot be empty"));
        }
        cars.forEach((Cars::validateCar));
    }

    private static void validateCar(final Car car) {
        if (car == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage("cars cannot contain null object"));
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Distance> getDistances() {
        return cars.stream()
            .map((Car::getDistance))
            .collect(Collectors.toUnmodifiableList());
    }

}
