package racinggame.domain;

import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {
    }

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    private int getRandomValue() {
        int random = (int) Math.floor(Math.random() * (9 - 0 + 1));
        return random;
    }

    private boolean canForward(int randomValue) {
        return randomValue >= 4;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial() {
        return this.trial;
    }
}
