package racingcar;

import racingcar.dto.UserInput;
import racingcar.domain.RacingGame;
import racingcar.strategy.RandomNumberGeneratorStrategy;
import racingcar.domain.Scores;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        final UserInput userInput = InputView.getUserInput();
        final RacingGame game = new RacingGame(userInput);
        run(game);
    }

    private static void run(final RacingGame racingGame) {
        RandomNumberGeneratorStrategy randomNumberGeneratorStrategy = new RandomNumberGeneratorStrategy();
        final List<Scores> records = racingGame.startGame(randomNumberGeneratorStrategy);
        ResultView.printResult(records);
    }
}
