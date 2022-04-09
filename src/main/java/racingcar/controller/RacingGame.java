package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        int carMoveCount = inputView.inputCarMoveCount();

        OutputView outputView = new OutputView();
        outputView.outputMoveCar(carCount, carMoveCount);
    }
}
