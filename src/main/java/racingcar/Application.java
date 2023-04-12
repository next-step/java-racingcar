package racingcar;

import racingcar.domain.InputData;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Scores;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final InputData inputData = InputView.getUserInput();
        final RacingGame game = new RacingGame(inputData);
        run(game);
    }

    private static void run(final RacingGame racingGame) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        final List<Scores> records = racingGame.startGame(numberGenerator);
        ResultView.printResult(records);
    }
}
