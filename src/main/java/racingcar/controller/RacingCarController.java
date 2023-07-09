package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.GameBoard;
import racingcar.domain.MovingStrategy;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run(MovingStrategy movingStrategy) {
        CarNames carNames = InputView.processCarNames();
        TryCount tryCount = InputView.processTryCount();
        GameBoard gameBoard = new GameBoard(carNames.toCars(), tryCount, movingStrategy);

        OutputView.printInitialStatus(gameBoard.getCars());
        playGame(gameBoard);
        OutputView.printWinner(gameBoard.getWinnerNames());
    }

    private void playGame(GameBoard gameBoard) {
        while (!gameBoard.isFinish()) {
            gameBoard.play();
            OutputView.printExecutionResult(gameBoard.getCars());
        }
    }

}
