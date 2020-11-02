package step3;

import step3.controller.InputController;
import step3.controller.ResultController;

public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputController.enterInput();
        RacingGame racingGame = new RacingGame(spec);
        racingGame.start();
        ResultController resultController = new ResultController();
        resultController.printRacingGame(racingGame.getRacingLog());
    }
}
