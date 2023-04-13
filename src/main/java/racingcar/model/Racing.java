package racingcar.model;

import racingcar.strategy.RandomMovingStrategy;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Racing {
    private final List<Car> cars;
    private final int totalRound;
    private int currentRound;

    public Racing(int totalRound, List<Car> cars) {
        Objects.requireNonNull(cars, "cars should not be null");

        if (totalRound <= 0) {
            throw new IllegalArgumentException("Total round must be positive: " + totalRound);
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("At least one car must be present");
        }

        this.totalRound = totalRound;
        this.cars = cars;
    }

    public static Racing init(int totalRound, List<String> names) {
        List<Car> cars = names.stream()
                .map((name) -> new Car(name, new RandomMovingStrategy()))
                .collect(toList());

        return new Racing(totalRound, cars);
    }

    public List<Car> cars() {
        return this.cars;
    }

    public int currentRound() {
        return this.currentRound;
    }

    public boolean isOver() {
        return this.currentRound == this.totalRound;
    }

    public void step() {
        if (isOver()) {
            throw new IllegalStateException("race is over");
        }
        cars.forEach(Car::move);
        currentRound++;
    }

    public List<Car> winners() {
        if (!isOver()) {
            throw new IllegalStateException("race is not over");
        }

        int maxDistance = cars.stream()
                .mapToInt(Car::distance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.distance() == maxDistance)
                .collect(toList());
    }

}
