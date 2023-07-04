package racingcar;

import java.util.List;


public class RacingCarRunner {
    public static void main(String[] args) {
        List<String> carNames = Input.processCarNames();
        int tryCount = Input.processTryCount();
        GameBoard gameBoard = new GameBoard(carNames);

        Output.printInitialStatus(gameBoard.getCars());
        for (int i = 0; i < tryCount; i++) {
            gameBoard.run();
            Output.printExecutionResult(gameBoard.getCars());
        }
        Output.printWinner(gameBoard.getWinnerNames());
    }
}
