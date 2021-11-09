package racingcar;

import racingcar.MovingStrategy.RandomMovingStrategy;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.TryCount;
import racingcar.exception.CreateCarCountException;
import racingcar.exception.TryCountException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();

        RacingGame racingGame = RacingGame.of(cars, tryCount);

        while (racingGame.nonOver()) {
            racingGame.play();
            OutputView.printResult(cars);
        }
    }

    private static Cars getCars() {
        int count = InputView.askCreateCarCount();

        try {
            return Cars.from(count, RandomMovingStrategy.getInstance());
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
