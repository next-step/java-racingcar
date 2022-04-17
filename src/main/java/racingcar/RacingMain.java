package racingcar;

import racingcar.controller.RacingGame;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(tryCount, carNames);

        Cars cars = null;
        while (!racingGame.end()) {
            cars = racingGame.race();
            OutputView.outputStatus(cars);
        }

        assert cars != null;
        Cars winnerCars = cars.findWinners();
        OutputView.outputWinners(winnerCars);
    }
}
