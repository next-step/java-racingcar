package racing;

import racing.board.RacingGameBoard;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    InputView inputView;

    ResultView resultView;

    RacingGameBoard gameBoard;

    public Application(InputView inputView, ResultView resultView, RacingGameBoard gameBoard) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.gameBoard = gameBoard;
    }

    public static void main(String[] args) {
        Application app = new Application(new InputView(), new ResultView(), new RacingGameBoard());
        app.run();
    }

    private void run() {
        inputView.render();

        gameBoard.createCars(inputView.getCount());
        List<String> results = new ArrayList<>();
        for (int i = 0; i < inputView.getTime(); i++) {
            gameBoard.moveCars();
            results.add(gameBoard.toString());
        }

        resultView.setResult(results
                .stream()
                .collect(Collectors.joining("\n")));
        resultView.render();
    }
}
