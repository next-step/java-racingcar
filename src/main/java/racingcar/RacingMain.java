package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int carMoveCount = InputView.inputCarMoveCount();

        new RacingGame(carNames, carMoveCount).start();
    }
}
