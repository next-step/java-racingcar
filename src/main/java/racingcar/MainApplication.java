package racingcar;

import racingcar.ui.InputView;

public class MainApplication {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMoveCount();
        RacingCar.play(carNames,moveCount);
    }
}
