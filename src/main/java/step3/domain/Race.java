package step3.domain;

import step3.view.RaceView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int raceRound;

    public Race(int carCount, int raceRound) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.raceRound = raceRound;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void start() {
        RaceView.displayDiscription();
        for (int round = 0; round < raceRound; round++) {
            moveCars();
            RaceView.displayRaceSituation(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (CarRandomMovement.canMove()) {
                car.move();
            }
        }
    }
}
