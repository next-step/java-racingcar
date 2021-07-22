package racingcar;

import racingcar.ui.InputView;

public class MainApplication {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int moveCount = InputView.inputMoveCount();
        RacingCar.play(carCount,moveCount);
    }
}
