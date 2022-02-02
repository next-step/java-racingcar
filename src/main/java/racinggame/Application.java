package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.service.RacingGameService;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {

    public static void main(String[] args) {

        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();
        final RacingGameService racingGameService = new RacingGameService();
        final RacingGameController racingGameController = initGameController(inputView, resultView,
            racingGameService);
        racingGameController.run();
    }

    private static RacingGameController initGameController(InputView inputView,
        ResultView resultView, RacingGameService racingGameService) {
        return new RacingGameController(inputView, resultView, racingGameService);
    }

}
