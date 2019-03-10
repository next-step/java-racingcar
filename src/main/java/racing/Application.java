package racing;

import racing.board.RacingGameBoard;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int count = InputView.inputCount();
        int time = InputView.inputTime();

        gameBoard.createCars(count);

        List<String> results = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            gameBoard.moveCars();
            results.add(gameBoard.toString());
        }

        ResultView.render(results
            .stream()
            .collect(Collectors.joining("\n")));
    }
}
