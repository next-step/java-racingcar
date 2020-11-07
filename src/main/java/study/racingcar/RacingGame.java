package study.racingcar;

import study.racingcar.racingcars.RacingCars;
import study.racingcar.view.ResultView;

/**
 * RacingGame을 진행하는 책임
 */
public class RacingGame {

    private GameConfiguration gameConfiguration;
    private ResultView resultView;

    public RacingGame(GameConfiguration gameConfiguration, ResultView resultView) {
        this.gameConfiguration = gameConfiguration;
        this.resultView = resultView;
    }

    public void startGame() {

        RacingCars racingCars = gameConfiguration.initRacingCars();

        for (int attempt = 0; gameConfiguration.doMoreAttempt(attempt); attempt++) {
            racingCars.nextAttempt();
            racingCars.displayCurrentStatus(resultView);
        }

    }

}
