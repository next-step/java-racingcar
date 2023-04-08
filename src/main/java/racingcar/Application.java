package racingcar;

import racingcar.domain.Game;
import racingcar.domain.InputData;
import racingcar.domain.Records;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        final InputData inputData = InputView.getUserInput();
        final Game game = new Game(inputData);

        run(game);
    }

    private static void run(final Game game) {
        final List<Records> records = game.playGame();

        ResultView.print(records);
    }
}
