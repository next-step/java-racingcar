package racingcar;

import racingcar.service.RacingCar;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCar racingCar = new RacingCar(inputView.CAR_COUNT, inputView.TRY_COUNT);
        racingCar.startGame();
    }
}
