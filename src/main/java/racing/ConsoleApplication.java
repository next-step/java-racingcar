package racing;

import racing.board.GameResult;
import racing.board.RacingGameBoard;
import racing.view.InputView;
import racing.view.ResultView;

public class ConsoleApplication {

    private RacingGameBoard gameBoard;

    public ConsoleApplication() {
        this.gameBoard = new RacingGameBoard();
    }

    public static void main(String[] args) {
        ConsoleApplication app = new ConsoleApplication();
        app.run();
    }

    private void run() {
        gameBoard.createCars(InputView.inputNames());
        int timesOfMoves = InputView.inputTime();

        ResultView.viewGameStart();
        GameResult gameResult = gameBoard.start(timesOfMoves);
        ResultView.viewHistory(gameResult.getHistory());
        ResultView.viewWinners(gameResult);
    }
}
