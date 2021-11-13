package step3;

import step3.controller.RacingGameController;
import step3.view.InputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        String names = InputView.inputCarNames();
        int gameRoundCount = InputView.inputGameRoundCount();
        System.out.println();

        start(names, gameRoundCount);
    }

    private static void start(String names, int gameRoundCount) {
        RacingGameController racingGameController = RacingGameController.create(gameRoundCount, names);
        racingGameController.start();
    }
}
