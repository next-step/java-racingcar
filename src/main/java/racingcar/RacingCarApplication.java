package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.ThresholdMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final int carCount = inputView.getCarCount();
        final int roundCount = inputView.getRoundCount();

        final RandomNumberGenerator numberGenerator = new RandomNumberGenerator(RANDOM_NUMBER_BOUND);
        final ThresholdMoveStrategy moveStrategy = new ThresholdMoveStrategy(MOVE_THRESHOLD, numberGenerator);
        final Race race = Race.of(carCount, roundCount, moveStrategy);
        final List<List<Integer>> roundResults = race.play();

        final ResultView resultView = new ResultView();
        resultView.showResult(roundResults);
    }
}
