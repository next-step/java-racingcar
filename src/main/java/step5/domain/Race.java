package step5.domain;

import java.util.List;

public class Race {

    private int currentRound = 1;

    private final int totalRound;

    private final Cars cars;

    public Race(int totalRound, List<String> nameOfCars, MovableStrategy movableStrategy) {
        this.totalRound = totalRound;
        this.cars = Cars.of(nameOfCars, movableStrategy);
    }

    public Cars cars() {
        return this.cars;
    }

    public boolean isInRace() {
        return this.currentRound <= this.totalRound;
    }

    public void nextRound() {
        this.currentRound++;
    }

    public void proceed() {
        for (Car car : this.cars) {
            car.moveOrStop();
        }
    }
}
