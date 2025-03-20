package step4.racingcar2.controller;

import step4.racingcar2.model.RacingCar;
import step4.racingcar2.model.RacingCarGameRound;

public class RacingCarGameRoundController {

    private RacingCarGameRound gameRound;

    public void roundReady(RacingCarGameRound gameRound) {
        this.gameRound = gameRound;
    }

    public void roundStart() {
        for (RacingCar car : this.gameRound.cars()) {
            RacingCarController carController = new RacingCarController();
            carController.ready(car);
            carController.run();
        }
    }

}
