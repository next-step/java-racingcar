package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        String carNames = racingCarView.inputCarInfo();

        RacingGame racingGame = new RacingGame();
        List<Cars> carsInfos = racingGame.createCarInformation(carNames);

        racingCarView.inputCycle();
        racingCarView.showResult(carsInfos);

        List<Cars> winnerNames = racingGame.selectWinners();
        racingCarView.showWinner(winnerNames);
    }
}
