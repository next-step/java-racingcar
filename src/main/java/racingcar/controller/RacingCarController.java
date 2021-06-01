package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        String carNames = RacingCarView.inputCarInfo();

        RacingGame racingGame = new RacingGame();
        Car car = racingGame.createCarInformation(carNames);

        RacingCarView.inputCycle();
        RacingCarView.showResult(car);

        List<Cars> winnerNames = racingGame.selectWinners();
        RacingCarView.showWinner(winnerNames);
    }
}
