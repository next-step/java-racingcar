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
        String carNames = racingCarView.inputCarInfo();

        RacingGame racingGame = new RacingGame();
        List<Car> carInfos = racingGame.splitString(carNames);
        racingCarView.inputCycle();
        racingCarView.showResult(carInfos);

        RacingResult racingResult = new RacingResult();
        List<Winner> winnerNames = racingResult.selectWinners(carInfos);
        racingCarView.showWinner(winnerNames);
    }
}
