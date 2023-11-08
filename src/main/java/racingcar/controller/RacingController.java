package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.utils.NameSplitter;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> carNames = NameSplitter.splitUserName(inputView.inputRacingCarNames());
        int tryCountNumber = inputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCountNumber);
    }

}
