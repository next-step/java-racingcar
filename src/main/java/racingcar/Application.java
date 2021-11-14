package racingcar;

import racingcar.MovingStrategy.RandomMovingStrategy;
import racingcar.domain.*;
import racingcar.exception.CreateCarCountException;
import racingcar.exception.TryCountException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.utils.StringUtils.split;

public class Application {
    public static void main(String[] args) {
        Cars cars = getCars();

        int tryCountInput = InputView.askTryCount();

        TryCount tryCount = getTryCount(tryCountInput);
        Round round = Round.from(tryCountInput);

        RacingGame racingGame = RacingGame.of(cars);

        GameLog gameLog = racingGame.play(tryCount, round);

        OutputView.printGameLog(gameLog);
        OutputView.printWinners(cars);
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

    private static TryCount getTryCount(int tryCount) {
        try {
            return TryCount.from(tryCount);
        } catch (TryCountException e) {
            OutputView.printTryCountExceptionMessage();
            int askTryCount = InputView.askTryCount();
            return getTryCount(askTryCount);
        }
    }
}
