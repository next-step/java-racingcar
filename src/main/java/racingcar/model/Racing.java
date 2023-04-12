package racingcar.model;

import java.util.List;
import java.util.Objects;

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
}
