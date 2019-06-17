package racing;

import racing.view.InputView;
import racing.view.RacingView;
import racing.view.ResultView;

public class RacingRunner {
    public static void main(String[] args) {
        RacingView racingView = new RacingView(new InputView(), new ResultView());
        RacingController controller = new RacingController(racingView);
        controller.makeNewGame(
            racingView.printCarQuestionAndGetAnswer(), 
            racingView.printTimeQuestionAndGetAnswer()
        );
        controller.stratGame();
    }
}
