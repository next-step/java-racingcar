package racingcar.controller;

import racingcar.view.InputView;

public class RacingCarController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNumber();
        int tryNum = inputView.inputTryNumber();
    }

}
