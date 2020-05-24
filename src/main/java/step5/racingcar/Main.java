package step5.racingcar;

import step5.racingcar.controller.RacingGameController;
import step5.racingcar.view.InputView;
import step5.racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGameController racingGameController = new RacingGameController(inputView, resultView);

        racingGameController.processUserInputs();
        racingGameController.startGame();
    }
}
