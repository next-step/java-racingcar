package racing;

import racing.car.CarRacing;
import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        CarRacing carRacing = inputView.makeCarRacing();
        carRacing.run();
        resultView.printResult(carRacing);
    }
}
