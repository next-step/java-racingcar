package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        final List<String> carNames = InputView.getCarNames();
        final int roundCount = InputView.getRoundCount();

        final Race race = new Race(carNames, roundCount, new RandomNumberGenerator());
        race.play();

        ResultView.showResult(race.getRoundResults());
    }
}
