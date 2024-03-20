package racingcar.ui;


import racingcar.domain.RacingCars;
import racingcar.domain.RandomMoveStrategy;

public class RacingCarGame {

    private final RacingCars racingCars;
    private int tryCount = 0;

    public RacingCarGame(RacingCars racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    public void playRacingGame() {
        for (int i = 0; i < tryCount; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        racingCars.moveCar(new RandomMoveStrategy());
    }

    public void showRacingResult() {
        RacingResultView.viewResult(racingCars);
    }
    public void showWinner() {
        RacingResultView.viewWinners(racingCars.getWinners());
    }
}
