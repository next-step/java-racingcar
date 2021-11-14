package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarInputView;

public class RacingApplication {
    public static void main(String[] args) {

        RacingCarController racingCarController = new RacingCarController(new RacingCarInputView());
        racingCarController.execute();

    }
}
