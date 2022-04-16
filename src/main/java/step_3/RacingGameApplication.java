package step_3;

import step_3.controller.RacingGameController;
import step_3.model.FinalResult;
import step_3.service.GameConditionService;
import step_3.service.RacingCarService;
import step_3.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        new RacingGameApplication().run(args);
    }

    public void run(String[] args) {
        RacingCarService racingCarService = new RacingCarService();
        GameConditionService gameConditionService = new GameConditionService();
        RacingGameController racingGameController = new RacingGameController(racingCarService, gameConditionService);
        FinalResult finalResult = racingGameController.gameStart();
        ResultView.printResult(finalResult);
    }
}
