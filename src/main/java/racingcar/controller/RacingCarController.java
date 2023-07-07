package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    private final Game game;
    private List<List<CarStatus>> gameStatus;
    private List<CarName> winners;

    public RacingCarController() {
        this(processInput());
    }

    private RacingCarController(Game game) {
        this.game = game;
    }

    private static <T> T retryIfException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryIfException(supplier);
        }
    }

    private static Game processInput() {
        Cars cars = retryIfException(InputView::readCarNames);
        TryCount tryCount = retryIfException(InputView::readTryCount);
        return new Game(cars, tryCount);
    }

    public void runGame() {
        gameStatus = game.run();
        winners = game.findWinnerNames();
    }

    public void printResult() {
        OutputView.printResult(gameStatus, winners);
    }
}
