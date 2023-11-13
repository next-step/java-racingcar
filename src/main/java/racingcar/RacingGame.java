package racingcar;

import racingcar.domain.Racing;
import racingcar.movablestrategy.RandomRacingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public static void main(String[] args) {
        String racerNames = InputView.racerNames();
        int roundCount = InputView.roundCount();
        Racing racing = new Racing(racerNames, roundCount);

        if (!racing.holdPossible()) {
            ResultView.noRace();
            return;
        }

        ResultView.racingStart();
        for (int round = 0; round < roundCount; round++) {
            ResultView.carStatPrint(racing.processRound(new RandomRacingStrategy()));
            ResultView.roundFinish();
        }

        ResultView.winner(racing.racingInfo());
    }
}
