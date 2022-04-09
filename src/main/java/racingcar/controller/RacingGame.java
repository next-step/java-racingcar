package racingcar.controller;

import racingcar.view.InputView;

public class RacingGame {
    public void start() {
        InputView inputView = new InputView();

        int carCount = inputView.inputCarCount();
        System.out.println("inputCarCount = " + carCount);
        int carMoveCount = inputView.inputCarMoveCount();
        System.out.println("inputCarMoveCount = " + carMoveCount);
    }
}
