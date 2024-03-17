package step3;

import step3.common.RandomNumberGenerator;
import step3.controller.RacingGameController;
import step3.model.CarsManager;
import step3.model.MovableStrategy;
import step3.service.RacingGameService;
import step3.view.InputView;
import step3.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int carCount = InputView.InputCarCount();
        int StageCount = InputView.InputStageCount();

        RacingGameService racingGameService = new RacingGameService();
        CarsManager carsManager = CarsManager.withCarCount(carCount);
        RacingGameController racingGameController = new RacingGameController(racingGameService);

        ResultView.viewResultPhrase();
        for (int i = 0; i < StageCount; i++) {
            ResultView.viewPositions(racingGameController.play(carsManager));
        }
    }
}
