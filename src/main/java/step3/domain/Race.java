package step3.domain;

import step3.view.RaceView;

import java.util.List;

public class Race {
    private final RacingCars cars;
    private final int raceRound;

    public Race(RacingCars cars, int raceRound) {
        this.cars = cars;
        this.raceRound = raceRound;
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public void start() {
        RaceView.displayDescription();
        for (int round = 0; round < raceRound; round++) {
            moveCars();
            RaceView.displayRaceSituation(getCars());
        }
        RaceView.displayWinners(cars.getWinner());
    }

    private void moveCars() {
        for (Car car : getCars()) {
            if (CarRandomMovement.canMove()) {
                car.move();
            }
        }
    }
}
