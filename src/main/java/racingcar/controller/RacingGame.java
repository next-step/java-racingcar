package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    public void startRacingGame(MovingStrategy movingStrategy) {
        Cars cars = new Cars(movingStrategy, InputView.inputNumberOfCars());
        int numberOfGames = InputView.inputNumberOfAttempts();
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
