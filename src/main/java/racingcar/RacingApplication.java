package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class RacingApplication {
    public static void main(String[] args) {

        RacingCarController racingCarController = new RacingCarController(new InputView());
        racingCarController.execute();

    }
}
