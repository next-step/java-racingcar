package racingcar;

import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingGame;
import racingcar.strategy.RandomNumberGeneratorStrategy;
import racingcar.domain.Scores;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        final PositiveNumber positiveNumber = InputView.getUserInput();
        final RacingGame game = new RacingGame(positiveNumber);
        run(game);
    }

    private static void run(final RacingGame racingGame) {
        RandomNumberGeneratorStrategy randomNumberGeneratorStrategy = new RandomNumberGeneratorStrategy();
        final List<Scores> records = racingGame.startGame(randomNumberGeneratorStrategy);
        ResultView.printResult(records);
    }
}
