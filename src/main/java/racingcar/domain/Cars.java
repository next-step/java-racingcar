package racingcar.domain;

import racingcar.dto.AttemptResult;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public AttemptResult getAttemptResult(final MoveStrategy moveStrategy) {
        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            car.move(moveStrategy);
            list.add(car.copy());
        }
        return new AttemptResult(list);
    }

    public List<String> getWinners() {
        Car max = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.isEqualsPosition(max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
