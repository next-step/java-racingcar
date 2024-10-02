package racing;

import java.util.List;
import racing.domain.RacingGame;
import racing.model.collection.Cars;
import racing.model.collection.GameResult;
import racing.ui.InputView;
import racing.ui.OutputView;
import racing.util.RandomNumberGenerator;

public class RacingGameRunner {

    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int roundCount = InputView.readRoundCount();

        Cars cars = Cars.create(carNames, new RandomNumberGenerator());
        RacingGame racingGame = RacingGame.setUp(roundCount, cars);

        GameResult gameResult = racingGame.start();
        OutputView.printGameResults(gameResult);
    }
}
