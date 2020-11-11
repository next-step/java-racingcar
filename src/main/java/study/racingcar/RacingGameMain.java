package study.racingcar;

import study.racingcar.domain.GameConfiguration;
import study.racingcar.domain.RacingGame;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.startRacingGame();
    }
}
