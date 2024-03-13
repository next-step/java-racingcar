package step3;

import step3.Controller.RacingGameController;
import step3.Service.RacingGameService;
import step3.View.InputView;
import step3.View.ResultView;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.InputCarCount();
        int StageCount = InputView.InputStageCount();

        RacingGameService racingGameService = new RacingGameService().setCarCount(carCount);
        RacingGameController racingGameController = new RacingGameController(racingGameService);

        ResultView.viewResultPhrase();
        for (int i = 0; i < StageCount; i++) {
            ResultView.viewPositions(racingGameController.play());
        }
    }
}
