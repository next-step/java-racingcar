package racingcar.domain;

import racingcar.MovableStrategy;

import java.util.*;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(final List<Car> cars) {
        if (calculateDistinctCarsSize(cars) != cars.size()) {
            throw new IllegalArgumentException("차의 이름은 중복될 수 없습니다.");
        }
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

    public void moveAll(final MovableStrategy movableStrategy) {
        cars.forEach(car -> move(movableStrategy, car));
    }

    private static void move(final MovableStrategy movableStrategy, final Car car) {
        if (movableStrategy.isMove()) {
            car.moveForward();
        }
    }

    private Position calculateMaxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다.")).getPosition();
    }

    private static long calculateDistinctCarsSize(final List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    private static List<Car> createCarList(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::create)
                .collect(Collectors.toUnmodifiableList());
    }
}
