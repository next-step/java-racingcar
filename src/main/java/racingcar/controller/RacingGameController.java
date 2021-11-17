package racingcar.controller;

import racingcar.MovingStrategy.RandomMovingStrategy;
import racingcar.domain.*;
import racingcar.exception.CreateCarCountException;
import racingcar.exception.RoundException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.utils.StringUtils.split;

public class RacingGameController {
    private RacingGameController() {
    }

    public static void run() {
        RacingGameController controller = new RacingGameController();

        Cars cars = controller.getCars();

        Round finalRound = controller.getFinalRound();

        RacingGame racingGame = RacingGame.of(cars);

        GameLog gameLog = racingGame.play(finalRound);

        OutputView.printGameLog(gameLog);
        Winners winners = cars.findWinners();
        OutputView.printWinners(winners);
    }

    private Cars getCars() {
        String input = InputView.askCreateCarNames();
        String[] carNames = split(input);
        try {
            return Cars.from(carNames, RandomMovingStrategy.getInstance());
        } catch (CreateCarCountException e) {
            OutputView.printCarCountExceptionMessage();
            return getCars();
        }
    }

    private Round getFinalRound() {
        try {
            int tryCount = InputView.askTryCount();
            return Round.from(tryCount);
        } catch (RoundException e) {
            OutputView.printTryCountExceptionMessage();
            return getFinalRound();
        }
    }

}
