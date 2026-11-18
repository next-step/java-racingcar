package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        final int carCount = InputView.getCarCount();
        final int roundCount = InputView.getRoundCount();

        final Race race = new Race(carCount, roundCount, new RandomNumberGenerator());
        race.play();

        ResultView.showResult(race.getRoundResults());
    }
}
