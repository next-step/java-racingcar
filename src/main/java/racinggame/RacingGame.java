package racinggame;

import racinggame.domain.Cars;

public class RacingGame {

    private final Cars cars;

    private final int reps;
    private int currentRep;

    public RacingGame(String[] carNames, int reps) {
        this.cars = new Cars(carNames);
        this.reps = reps;
        this.currentRep = 0;

    }

    public void race() {
        this.cars.moveCars();
        ++currentRep;
    }

    public Cars getWinners() {
        return this.cars.getWinners();
    }

    public boolean isFinished() {
        return currentRep >= reps;
    }


    public Cars getCars() {
        return this.cars;
    }
}
