package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        String carNames = InputView.inputCarInfo();

        RacingGame racingGame = new RacingGame();
        Cars cars = racingGame.createCarInformation(carNames);

        cars.setCycle(InputView.inputCycle());
        ResultView.showResult(cars);

        List<Car> winnerNames = racingGame.selectWinners();
        ResultView.showWinner(winnerNames);
    }
}
