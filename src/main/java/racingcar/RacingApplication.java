package racingcar;

import racingcar.domain.MoveStrategy;
import racingcar.domain.Racing;
import racingcar.domain.RacingRecords;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {

        String[] carNames = InputView.getInputCarNames();
        int tryCount = InputView.getInputTryCount();

        MoveStrategy moveStrategy = new RandomMoveStrategy();

        Racing racing = new Racing(carNames, moveStrategy);
        List<RacingRecords> racingRecords = racing.start(tryCount);

        ResultView.showRacingInfo(racingRecords);
    }
}
