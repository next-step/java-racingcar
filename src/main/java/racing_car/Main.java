package racing_car;

import racing_car.controller.InputController;
import racing_car.controller.ResultController;


public class Main {

    public static void main(String[] args) {
        RacingSpec spec = InputController.enterInput();
        RacingRecord racingRecord = new RacingGame(spec).play();
        ResultController.drawRacingResult(racingRecord);
    }
}
