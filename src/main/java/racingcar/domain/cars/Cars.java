package racingcar.domain.cars;

import static racingcar.config.RacingCarException.CARS_EMPTY;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.Position;
import racingcar.domain.movement.MovementStrategy;

public class Cars {

    private final List<Car> cars;

    Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Cars(final Car... cars) {
        this(Arrays.asList(cars));
    }

    public void moveForwardOrStop(final MovementStrategy movementStrategy) {
        this.cars.forEach(car -> car.moveForwardOrStop(movementStrategy));
    }

    public Cars winners() {
        final Position winningPosition = winningPosition();
        final List<Car> winners = this.cars.stream()
                .filter(car -> wins(car, winningPosition))
                .collect(Collectors.toUnmodifiableList());

        return new Cars(winners);
    }

    private boolean wins(final Car car, final Position winningPosition) {
        return car.equalsPosition(winningPosition);
    }

    private Position winningPosition() {
        return this.cars.stream()
                .map(Car::position)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalStateException(CARS_EMPTY.message()));
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
                .collect(Collectors.toUnmodifiableList());
    }
}
