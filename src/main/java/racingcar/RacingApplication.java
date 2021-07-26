package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {

        String[] carNames = InputView.getInputCarNames();
        int tryCount = InputView.getInputTryCount();

        Racing racing = new Racing(carNames);
        List<List<RacingRecord>> racingRecords = racing.start(tryCount);

        ResultView.showRacingInfo(racingRecords);

        List<RacingRecord> finalRacingRecord = racingRecords.get(racingRecords.size() - 1);
        ResultView.showRacingWinner(finalRacingRecord);
    }
}
