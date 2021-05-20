package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingGame racingGame = new RacingGame();

        String carName = racingCarView.inputCarInfo();
        List<Car> carInfo = racingGame.splitString(carName);

        racingCarView.inputCycle();
        racingCarView.showResult(carInfo);

        
    }
}
