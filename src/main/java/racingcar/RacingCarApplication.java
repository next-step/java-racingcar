package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.RacingCarOutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new RacingCarInputView(),
                                                                 new RacingCarOutputView());
        controller.execute();
    }
}
