package step4;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int currentRound = 1;

    private final int totalRound;

    private final Cars cars;

    public Race(int totalRound, String[] nameOfCars, MovableStrategy movableStrategy) {
        this.totalRound = totalRound;
        List<Car> cars = new ArrayList<>();
        for (String name : nameOfCars) {
            cars.add(new Car(name, movableStrategy));
        }
        this.cars = new Cars(cars);
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
