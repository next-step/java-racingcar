package controller;

import view.InputView;

public class RacingGameController {
    public static void main(String args[]) {
        InputView inputView = new InputView();
        int inputNumber = inputView.getInputCarsNumber();
    }
}
