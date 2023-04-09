package controller;

import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public static void main(String[] args) {
        int createCarCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(createCarCount);

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            OutputView.printCarsPositionStatus(racingCarGame.playAndReturnCars());
        }
    }
}
