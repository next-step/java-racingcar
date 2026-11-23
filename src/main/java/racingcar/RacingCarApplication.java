package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        final List<CarName> carNames = InputView.getCarNames();
        final TryCount tryCount = InputView.getTryCount();
        final Race race = new Race(carNames, tryCount, new RandomNumberGenerator());

        ResultView.showResultTitle();
        Cars cars;
        do {
            cars = race.playRound();
            ResultView.showRound(cars);
        } while (race.isInProgress());

        ResultView.showWinners(cars.getWinners());
    }
}
