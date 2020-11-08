package step3;

import step3.controller.InputController;
import step3.controller.ResultController;
import step3.strategy.RandomStrategy;


public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputController.enterInput();
        RacingRecord racingRecord = new RacingGame(spec).play();
        ResultController.drawRacingResult(racingRecord);
    }
}
