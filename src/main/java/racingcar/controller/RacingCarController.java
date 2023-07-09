package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    private static final String ERROR_GAME_NOT_RUN = "게임이 정상적으로 실행되지 않았습니다. 게임 실행 후 출력 가능합니다.";

    private final Game game;
    private List<List<CarStatus>> gameStatus = null;
    private List<CarName> winners = null;

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

    /** runGame() 실행 이후 실행해야 정상적으로 게임 결과를 출력합니다. */
    public void tryPrintResult() {
        try {
            printResult();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printResult() {
        if (isNullStatus() || isEmptyStatus()) {
            throw new IllegalStateException(ERROR_GAME_NOT_RUN);
        }
        OutputView.printResult(gameStatus, winners);
    }

    private boolean isNullStatus() {
        return gameStatus == null || winners == null;
    }

    private boolean isEmptyStatus() {
        return gameStatus.isEmpty() || winners.isEmpty();
    }
}
