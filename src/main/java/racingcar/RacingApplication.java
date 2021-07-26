package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {

        int carCount = InputView.getInputCarCount();
        int tryCount = InputView.getInputTryCount();

        Racing racing = new Racing(carCount);
        List<List<RacingRecord>> racingRecords = racing.start(tryCount);

        ResultView.showRacingInfo(racingRecords);
    }
}
