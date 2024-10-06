package racingcar;

import racingcar.controller.RacingGameController;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingGameController controller = new RacingGameController();
        controller.run();
    }
}
