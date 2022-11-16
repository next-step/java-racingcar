package laststep.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import laststep.service.MoveStrategy;
import laststep.service.RandomMoveStrategy;

public class Cars {
    private static final Random random = new Random();
    private final MoveStrategy strategy;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.strategy = new RandomMoveStrategy();
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    public Cars findWinners() {
        Car winner = findWinnerPosition();
        return new Cars(cars.stream()
                .filter(car -> car.isWinner(winner))
                .collect(Collectors.toList()));
    }

    private Car findWinnerPosition() {
        return Collections.max(cars);
    }

    private void validate(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 리스트는 한 대 이상이어야 해요");
        }
    }

    public String printWinners(String separator) {
        return cars.stream()
                .map(Car::printName)
                .collect(Collectors.joining(separator));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
        return Objects.hash(cars);
    }
}
