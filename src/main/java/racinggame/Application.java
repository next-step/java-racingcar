package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();
        final RacingGameController racingGameController = initGameController(inputView, resultView);
        racingGameController.run();
    }

    private static RacingGameController initGameController(InputView inputView,
        ResultView resultView) {
        return new RacingGameController(inputView, resultView);
    }
}
