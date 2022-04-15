package controller;

import controller.constant.RacingCarSetting;
import helper.RandomHelper;
import view.InputView;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = new InputView();
        int carsNumber = inputView.getInputCarsNumber();
        int carMoveCount = inputView.getInputCarMoveCount();
        int randomNumber = RandomHelper.makeRandomNumber(RacingCarSetting.RACING_DEFAULT_RANDOM_NUMBER_BOUND);

    }
}
