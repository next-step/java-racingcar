package step3.domain;

import step3.view.RaceView;

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
        RaceView.displayDiscription();
        for (int round = 0; round < raceRound; round++) {
            moveCars();
            RaceView.displayRaceSituation(cars);
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
