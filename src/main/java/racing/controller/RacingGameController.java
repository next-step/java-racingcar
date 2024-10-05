package racing.controller;

import java.util.List;
import racing.domain.RacingGame;
import racing.model.collection.Cars;
import racing.model.collection.GameResult;
import racing.util.RandomNumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameController {

    public static void main(String[] args) {
        List<String> carNames = InputView.readCarNames();
        int roundCount = InputView.readRoundCount();

        Cars cars = Cars.create(carNames, new RandomNumberGenerator());
        RacingGame racingGame = RacingGame.setUp(roundCount, cars);

        GameResult gameResult = racingGame.start();
        OutputView.printGameResults(gameResult);
    }
}
