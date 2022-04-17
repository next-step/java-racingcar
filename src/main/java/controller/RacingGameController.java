package controller;

import model.PositiveNumber;
import service.RacingCarGame;
import view.InputView;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = InputView.getInstance();

        PositiveNumber carsNumber = inputView.getInputCarsNumber();
        PositiveNumber carMoveCount = inputView.getInputCarMoveCount();

        RacingCarGame racingCarGame = RacingCarGame.getInstance();
        racingCarGame.play(carsNumber, carMoveCount);
    }

}
