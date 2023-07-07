package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.GameBoard;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        CarNames carNames = InputView.processCarNames();
        TryCount tryCount = InputView.processTryCount();
        GameBoard gameBoard = new GameBoard(carNames.toCars());

        OutputView.printInitialStatus(gameBoard.getCars());
        playGame(tryCount, gameBoard);
        OutputView.printWinner(gameBoard.getWinnerNames());
    }

    private void playGame(TryCount tryCount, GameBoard gameBoard) {
        for (TryCount t = tryCount; !t.isZero(); t = t.decrease()) {
            gameBoard.play();
            OutputView.printExecutionResult(gameBoard.getCars());
        }
    }

}
