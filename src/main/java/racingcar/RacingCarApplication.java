package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Game;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        Game game = racingCarController.initializeGameInfo();
        racingCarController.start(game);
    }
}
