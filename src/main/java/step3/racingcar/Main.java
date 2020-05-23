package step3.racingcar;

import step3.racingcar.controller.RacingGameController;
import step3.racingcar.domain.Message;
import step3.racingcar.domain.RacingGame;
import step3.racingcar.view.InputView;
import step3.racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGameController racingGameController = new RacingGameController(inputView, resultView);

        racingGameController.processUserInput();
        racingGameController.startGame();
    }
}
