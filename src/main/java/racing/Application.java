package racing;

import racing.board.GameResult;
import racing.board.RacingGameBoard;
import racing.view.InputView;
import racing.view.ResultView;

public class Application {

    private RacingGameBoard gameBoard;

    public Application() {
        this.gameBoard = new RacingGameBoard();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        gameBoard.createCars(InputView.inputNames());
        int timesOfMoves = InputView.inputTime();

        ResultView.viewStart();
        GameResult gameResult = gameBoard.start(timesOfMoves);
        ResultView.viewWinners(gameResult);
    }
}
