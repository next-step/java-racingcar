package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Racing racing = new Racing(inputView.inputCarNames(), inputView.inputAttemptCount());
        ResultView.resultMessage();
        racing.play();
        ResultView.showWinner(racing.winners());
    }
}
