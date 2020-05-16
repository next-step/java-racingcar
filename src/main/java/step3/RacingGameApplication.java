package step3;

import step3.controller.RacingGameController;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameController racingGameController = RacingGameController
                .start(InputView.getRacingCarNames(), InputView.getGameRound());

        while (racingGameController.hasNextRound()) {
            racingGameController.nextRound();
            ResultView.printPosition(racingGameController.getRacingCars());
        }
    }
}
