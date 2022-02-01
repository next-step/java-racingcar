package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.domain.history.RoundHistories;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final RacingGameController racingGameController = initGameController(inputView);
        final RoundHistories roundHistories = racingGameController.race();

        final ResultView resultView = new ResultView();
        resultView.printResult(roundHistories);
    }

    private static RacingGameController initGameController(InputView inputView) {
        return new RacingGameController(inputView.inputPlayerName(), inputView.inputTryNumber());
    }

}
