package racingcar.domain;

import racingcar.MovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;
    private Position maxPosition;

    private Cars() {
        this.cars = new ArrayList<>();
        this.maxPosition = Position.of();
    }

    public static Cars create() {
        return new Cars();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public List<String> findMaxPosition() {
        return cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .map(Car::getName)
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
}
