package step3;

import step3.strategy.RandomStrategy;

import java.util.List;

public class RacingGame {

    private final RacingCarManager racingCarManager;

    public RacingGame(int carCount) {
        this.racingCarManager = new RacingCarManager(new RandomStrategy());
        this.racingCarManager.joinCars(carCount);
    }

    public void playStep() {
        racingCarManager.moveCars();
    }

    public List<Integer> getStepResult() {
        return racingCarManager.getRacingStatus();
    }

}
