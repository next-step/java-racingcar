package step3;

import step3.strategy.RandomStrategy;

public class RacingGame {

    private final RacingCarManager racingCarManager;

    public RacingGame(int carCount) {
        this.racingCarManager = new RacingCarManager(carCount, new RandomStrategy());
    }

    public void playStep() {
        racingCarManager.moveCars();
    }

    public RacingCarList getRacingCarList() {
        return racingCarManager.getRacingCarList();
    }

}
