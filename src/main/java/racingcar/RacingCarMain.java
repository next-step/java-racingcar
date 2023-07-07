package racingcar;

import racingcar.controller.RacingCarController;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
        racingCarController.printResult();
    }
}
