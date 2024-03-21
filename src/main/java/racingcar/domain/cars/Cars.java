package racingcar.domain.cars;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.movement.MovementStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveForwardOrStop(final MovementStrategy movementStrategy) {
        this.cars.forEach(car -> car.moveForwardOrStop(movementStrategy));
    }

    public List<String> winnerNames() {
        final int maxPosition = maxPosition();

        return this.cars().stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return this.cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public List<Car> cars() {
        return this.cars.stream()
                .map(Car::copyOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Cars from(final CarNames carNames) {
        return new Cars(createCars(carNames));
    }

    private static List<Car> createCars(final CarNames carNames) {
        return carNames.names()
                .stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }
}
