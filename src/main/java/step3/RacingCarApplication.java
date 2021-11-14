package step3;

import step3.controller.RacingGameController;
import step3.domain.GameHistory;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        //input
        String names = InputView.inputCarNames();
        int gameRoundCount = InputView.inputGameRoundCount();
        System.out.println();
        //start
        ResultView.start();
        GameHistory history = start(names, gameRoundCount);
        //result
        ResultView.result(history);
    }

    private static GameHistory start(String names, int gameRoundCount) {
        RacingGameController racingGameController = RacingGameController.create(gameRoundCount, names);
        return racingGameController.start();
    }
}
