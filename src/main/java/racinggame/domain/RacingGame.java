package racinggame.domain;

import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial(){
        return this.trial;
    }
}
