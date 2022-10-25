package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.ExceptionMessageUtils;

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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getFarthestMovedCars() {
        return getFarthestMovedCar(cars)
            .map(farthestMovedCar -> filterSameDistanceCars(cars, farthestMovedCar))
            .orElse(Collections.emptyList());
    }

    private static List<Car> filterSameDistanceCars(final List<Car> cars, final Car car) {
        if (cars == null || cars.isEmpty()) {
            return Collections.emptyList();
        }
        return cars.stream()
            .filter((each -> each.hasSameDistanceWith(car)))
            .collect(Collectors.toUnmodifiableList());
    }

    private static Optional<Car> getFarthestMovedCar(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            return Optional.empty();
        }
        final List<Car> tmp = new ArrayList<>(cars);
        tmp.sort(Cars::compareCarByDistance);
        return Optional.of(tmp.get(0));
    }

    private static int compareCarByDistance(final Car car1, final Car car2) {
        if (car1.isFartherMovedThan(car2)) {
            return -1;
        }
        if (car1.isLessMovedThan(car2)) {
            return 1;
        }
        return 0;
    }

}
