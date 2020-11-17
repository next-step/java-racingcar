package racingcar;

import racingcar.controller.RacingCarController;

public class MainSimulator {

    private static final RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {
        racingCarController.getRacingCarResult();
    }

}
