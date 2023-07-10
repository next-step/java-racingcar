package racingcar.domain;

import racingcar.MovableStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;
    private Position maxPosition;

    private Cars(final List<Car> cars) {
        this.cars = cars;
        this.maxPosition = Position.from();
    }

    public static Cars of(final String[] carNames) {
        return new Cars(createCarList(carNames));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> findMaxPositionCars() {
        return cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    public void move(final MovableStrategy movableStrategy) {
        cars.forEach(car -> {
            if (movableStrategy.isMove()) {
                car.moveForward();
                maxPosition = maxPosition.matchPosition(car.getPosition());
            }
        });
    }

    private static List<Car> createCarList(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::create)
                .collect(Collectors.toUnmodifiableList());
    }
}
