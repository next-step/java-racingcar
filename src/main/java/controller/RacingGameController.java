package controller;

import view.InputView;

public class RacingGameController {
    public static void main(String args[]) {
        InputView inputView = new InputView();
        int carsNumber = inputView.getInputCarsNumber();
        int carMoveCount = inputView.getInputCarMoveCount();
    }
}
