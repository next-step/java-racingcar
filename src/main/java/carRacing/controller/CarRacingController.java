package carRacing.controller;

import carRacing.view.InputView;

public class CarRacingController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carNum = inputView.inputCarNumber();
        int tryNum = inputView.inputTryNumber();
    }

}
