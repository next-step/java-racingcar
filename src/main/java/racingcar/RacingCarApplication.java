package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.ThresholdMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        final int carCount = InputView.getCarCount();
        final int roundCount = InputView.getRoundCount();

        final RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        final ThresholdMoveStrategy moveStrategy = new ThresholdMoveStrategy(numberGenerator);
        final Race race = Race.of(carCount, roundCount, moveStrategy);
        final List<List<Integer>> roundResults = race.play();

        ResultView.showResult(roundResults);
    }
}
