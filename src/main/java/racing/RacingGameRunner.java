package racing;

import java.util.List;
import racing.domain.GameResult;
import racing.domain.RacingGame;
import racing.ui.InputView;
import racing.ui.OutputView;

public class RacingGameRunner {

    public static void main(String[] args) {
        int carCount = InputView.readCarCount();
        int roundCount = InputView.readRoundCount();

        RacingGame racingGame = RacingGame.setUp(roundCount, carCount);
        List<GameResult> gameResults = racingGame.start();

        OutputView.printGameResults(gameResults);
    }
}
