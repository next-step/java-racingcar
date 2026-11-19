package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        final int roundCount = InputView.getRoundCount();

        final Race race = new Race(List.of("car1", "car2"), roundCount, new RandomNumberGenerator());
        race.play();

        ResultView.showResult(race.getRoundResults());
    }
}
