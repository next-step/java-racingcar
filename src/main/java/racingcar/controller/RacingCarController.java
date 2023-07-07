package racingcar.controller;

import racingcar.domain.CarName;
import racingcar.domain.GameBoard;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    public void run() {
        List<CarName> carNames = InputView.processCarNames();
        TryCount tryCount = InputView.processTryCount();
        GameBoard gameBoard = new GameBoard(carNames);

        OutputView.printInitialStatus(gameBoard.getCars());
        playGame(tryCount, gameBoard);
        OutputView.printWinner(gameBoard.getWinnerNames());
    }

    private void playGame(TryCount tryCount, GameBoard gameBoard) {
        for (TryCount t = tryCount; t.isZero(); t = t.decrease()) {
            gameBoard.run();
            OutputView.printExecutionResult(gameBoard.getCars());
        }
    }

}
