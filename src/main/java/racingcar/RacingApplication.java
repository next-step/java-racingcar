package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingRecord;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {

        String[] carNames = InputView.getInputCarNames();
        int tryCount = InputView.getInputTryCount();

        Racing racing = new Racing(carNames);
        List<List<RacingRecord>> racingRecords = racing.start(tryCount);

        ResultView.showRacingInfo(racingRecords);
    }
}
