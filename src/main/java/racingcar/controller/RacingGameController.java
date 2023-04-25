package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Scores;
import racingcar.dto.UserInput;
import racingcar.strategy.RandomNumberGeneratorStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameController {
    public void run() {
        final UserInput userInput = InputView.getUserInput();
        final Cars cars = new Cars(userInput.getCarNames());
        final RacingGame racingGame = new RacingGame(userInput.getGameRound());

        final List<Scores> records = racingGame.startGame(cars, new RandomNumberGeneratorStrategy());

        ResultView.printResult(records);
    }
}
