package racingcar;

import racingcar.MovingStrategy.RandomMovingStrategy;
import racingcar.domain.Cars;
import racingcar.domain.GameLog;
import racingcar.domain.RacingGame;
import racingcar.domain.TryCount;
import racingcar.exception.CreateCarCountException;
import racingcar.exception.TryCountException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.utils.StringUtils.split;

public class Application {
    public static void main(String[] args) {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();

        RacingGame racingGame = RacingGame.of(cars, tryCount);

        GameLog gameLog = racingGame.play();

        OutputView.printGameLog(gameLog);
    }

    private static Cars getCars() {
        String input = InputView.askCreateCarNames();
        String[] carNames = split(input);
        try {
            return Cars.from(carNames, RandomMovingStrategy.getInstance());
        } catch (CreateCarCountException e) {
            OutputView.printCarCountExceptionMessage();
            return getCars();
        }
    }

    private static TryCount getTryCount() {
        int tryCount = InputView.askTryCount();

        try {
            return TryCount.from(tryCount);
        } catch (TryCountException e) {
            OutputView.printTryCountExceptionMessage();
            return getTryCount();
        }
    }
}
