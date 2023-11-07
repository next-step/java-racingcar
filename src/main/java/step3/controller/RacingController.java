package step3.controller;

import step3.domain.RacingGame;
import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int racingCarNumber = inputView.inputRacingCarCount();
        int tryCountNumber = inputView.inputTryCount();
        RacingGame racingGame = new RacingGame(racingCarNumber, tryCountNumber);

        resultView.printResultMessage();
        racingGame.play();
        resultView.printRacingResults(racingGame.getRounds());

    }

}
