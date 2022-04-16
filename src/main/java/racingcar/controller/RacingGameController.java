package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final MovingStrategy movingStrategy;

    public RacingGameController(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void start() {
        String[] carNames = InputView.inputCarNames();
        int numberOfGames = InputView.inputNumberOfAttempts();

        Cars cars = new Cars();
        cars.create(movingStrategy, carNames);

        progressNumberOfGames(cars, numberOfGames);
    }

    private void progressNumberOfGames(Cars cars, int numberOfGames) {
        OutputView.printCarRacingResult();
        for (int i = 0; i < numberOfGames; i++) {
            cars.runRace();
            OutputView.printCarRacingIntermediateState(cars);
        }

        OutputView.printWinner(cars);
    }
}
