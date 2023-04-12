package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private final int carCount;
    private final int raceRound;

    public Race(int carCount, int raceRound) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.carCount = carCount;
        this.raceRound = raceRound;
    }

    public void start() {
        for (int round = 0; round < raceRound; round++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (int carNumber = 0; carNumber < carCount; carNumber++) {
            if (CarRandomMovement.canMove()) {
                cars.get(carNumber).move();
            }
        }
    }
}
