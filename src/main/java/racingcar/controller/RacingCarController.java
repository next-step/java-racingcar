package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        String carNames = racingCarView.inputCarInfo();

        RacingGame racingGame = new RacingGame();
        List<Car> carInfos = racingGame.createCarInformation(carNames);

        racingCarView.inputCycle();
        racingCarView.showResult(carInfos);

        List<Car> winnerNames = racingGame.selectWinners();
        racingCarView.showWinner(winnerNames);
    }
}
