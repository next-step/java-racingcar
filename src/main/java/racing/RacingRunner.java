package racing;

import racing.controller.RacingController;
import racing.view.InputView;
import racing.view.RacingView;
import racing.view.ResultView;

public class RacingRunner {
    public static void main(String[] args) {
        RacingView racingView = new RacingView();
        RacingController controller = new RacingController(racingView);
        controller.makeNewGame(
            racingView.printCarQuestionAndGetAnswer(), 
            racingView.printTimeQuestionAndGetAnswer()
        );
        controller.processGame();
    }
}
