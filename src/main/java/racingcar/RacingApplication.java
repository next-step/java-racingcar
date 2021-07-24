package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingApplication {

    public static void main(String[] args) {

        int carCount = InputView.getInputCarCount();
        int tryCount = InputView.getInputTryCount();

        Racing racing = new Racing(carCount);
        racing.start(tryCount);

        ResultView.showRacingInfo(racing.getRacingHistory());
    }
}
