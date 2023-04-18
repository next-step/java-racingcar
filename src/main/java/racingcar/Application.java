package racingcar;

import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Scores;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        final PositiveNumber positiveNumber = InputView.getUserInput();
        final RacingGame game = new RacingGame(positiveNumber);
        run(game);
    }

    private static void run(final RacingGame racingGame) {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        final List<Scores> records = racingGame.startGame(numberGenerator);
        ResultView.printResult(records);
    }
}
