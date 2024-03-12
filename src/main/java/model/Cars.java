package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("레이싱 게임에 참가할 자동차를 1대 이상 입력해주세요");
        }

        this.cars = cars;
    }

    public Cars move() {
        List<Car> records = new ArrayList<>();
        for (Car car : cars) {
            Car moved = car.move();
            records.add(moved);
        }

        return new Cars(records);
    }

    public List<Car> winners() {
        Position position = new Position(maxPosition());
        return this.cars.stream()
                .filter(car -> car.isSamePosition(position))
                .collect(toList());
    }

    private int maxPosition() {
        return this.cars.stream()
                .max(Car::compareTo)
                .map(Car::getPosition)
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Cars cars1 = (Cars) other;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
