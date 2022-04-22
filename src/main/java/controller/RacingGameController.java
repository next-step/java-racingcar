package controller;

import model.MoveCount;
import service.RacingCarGame;
import view.InputView;

public class RacingGameController {

    public static void main(String args[]) {
        InputView inputView = InputView.getInstance();

        String carsName = inputView.getInputCarsName();
        MoveCount moveCount = inputView.getInputCarMoveCount();

        RacingCarGame racingCarGame = new RacingCarGame(carsName, moveCount);

        while (racingCarGame.isDone()) {
            racingCarGame.race();
        }
    }

}
