package controller;

import model.PositiveNumber;
import service.RacingCarGame;
import view.InputView;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = InputView.getInstance();

        String carsName = inputView.getInputCarsName();
        PositiveNumber carMoveCount = inputView.getInputCarMoveCount();

        RacingCarGame racingCarGame = RacingCarGame.getInstance();
        racingCarGame.play(carsName, carMoveCount);
    }

}
