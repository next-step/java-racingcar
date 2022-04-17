package racingcar;

import racingcar.controller.RacingGame;
import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int carMoveCount = InputView.inputCarMoveCount();

        Cars cars = CarsFactory.create(carNames);
        RacingGame racingGame = new RacingGame(carMoveCount);

        while (!racingGame.end()) {
            racingGame.race(cars);
            OutputView.outputStatus(cars);
        }

        Cars winnerCars = cars.findWinners();
        OutputView.outputWinners(winnerCars);
    }
}
