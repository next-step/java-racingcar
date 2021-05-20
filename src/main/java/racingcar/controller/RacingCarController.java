package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;
import racingcar.domain.Winner;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingGame racingGame = new RacingGame();
        RacingResult racingResult = new RacingResult();

        String carName = racingCarView.inputCarInfo();
        List<Car> carInfo = racingGame.splitString(carName);

        racingCarView.inputCycle();
        racingCarView.showResult(carInfo);

        List<Winner> winnerNames = racingResult.selectWinners(carInfo);
        racingCarView.showWinner(winnerNames);
    }
}
