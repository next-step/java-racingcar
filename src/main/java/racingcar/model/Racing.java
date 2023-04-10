package racingcar.model;

import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final int totalRound;
    private int currentRound;

    public Racing(int totalRound, List<Car> cars) {
        if (totalRound < 0) {
            throw new IllegalArgumentException("input must be not negative: " + totalRound);
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
