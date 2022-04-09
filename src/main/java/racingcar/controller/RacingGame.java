package racingcar.controller;

import racingcar.view.InputView;

public class RacingGame {
    public void start() {
        InputView inputView = new InputView();
        int inputCarCount = inputView.inputCarCount();
        System.out.println("inputCarCount = " + inputCarCount);
    }
}
