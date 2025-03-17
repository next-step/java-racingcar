package step3.racingcar.controller;

import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarGameRound;

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
