package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        resultView.result(inputView.getRacingRound(), inputView.getRacingCar());

    }
}
