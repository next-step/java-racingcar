package racingStep3;

import racingStep3.controller.RacingCarController;
import racingStep3.view.InputView;

public class RacingApplication {
    public static void main(String[] args) {

        RacingCarController racingCarController = new RacingCarController(new InputView());
        racingCarController.execute();

    }
}
