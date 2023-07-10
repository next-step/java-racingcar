package racingcar.domain;

import racingcar.MovableStrategy;

import java.util.*;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(final String[] carNames) {
        return new Cars(createCarList(carNames));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> findMaxPositionCars() {
        final Position maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private Position calculateMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다.")).getPosition();
    }

    public void move(final MovableStrategy movableStrategy) {
        cars.forEach(car -> {
            if (movableStrategy.isMove()) {
                car.moveForward();
            }
        });
    }

    private static List<Car> createCarList(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::create)
                .collect(Collectors.toUnmodifiableList());
    }
}
