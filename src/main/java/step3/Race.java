package step3;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int currentRound = 1;

    private final int totalRound;

    private final List<Car> cars = new ArrayList<>();

    public Race(int totalRound, int numberOfCar) {
        this.totalRound = totalRound;
        for (int i = 0; i < numberOfCar; i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> cars() {
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
