package step3;

import step3.model.CarsManager;
import step3.model.RacingGame;
import step3.ui.InputView;
import step3.ui.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        int carCount = InputView.InputCarCount();
        int StageCount = InputView.InputStageCount();

        RacingGame racingGame = new RacingGame(carCount);


        ResultView.viewResultPhrase();

        for (int i = 0; i < StageCount; i++) {
            racingGame.progressStage();
            ResultView.viewPositions(racingGame.getResult());
        }
    }
}
