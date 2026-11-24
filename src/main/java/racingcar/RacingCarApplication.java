package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.view.RoundResult;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        final List<String> carNames = InputView.getCarNames();
        final TryCount tryCount = InputView.getTryCount();
        final Race race = new Race(carNames, tryCount, new RandomNumberGenerator());

        ResultView.showResultTitle();
        RoundResult result;
        do {
            result = race.playRound();
            ResultView.showRound(result);
        } while (race.isInProgress());

        ResultView.showWinners(result);
    }
}
