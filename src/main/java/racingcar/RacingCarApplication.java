package racingcar;

import racingcar.controller.RacingCarController;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.execute();
    }
}
