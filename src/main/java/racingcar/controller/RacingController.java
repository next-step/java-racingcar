package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.utils.NameSplitter;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> carNames = NameSplitter.splitUserName(inputView.inputRacingCarNames());
        int tryCountNumber = inputView.inputTryCount();

        resultView.printResultMessage();
        RacingGame racingGame = new RacingGame(carNames, tryCountNumber);
        racingGame.play(new RandomNumberGenerator());
        resultView.printRacingResults(racingGame.getRounds());
        resultView.printWinner(racingGame.getWinners());
    }

}
