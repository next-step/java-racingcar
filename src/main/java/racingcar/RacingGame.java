package racingcar;

import racingcar.controller.RacingGameController;

public class RacingGame {

    public void run() {
        RacingGameController controller = new RacingGameController();

        controller.startRacingGame();
        controller.enterCars();
        controller.readyGame();
        controller.startGame();
        controller.racingResult();
    }
}
