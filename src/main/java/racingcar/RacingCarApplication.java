package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.ResultCarOutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new RacingCarInputView(),
                                                                 new ResultCarOutputView());
        controller.execute();
    }
}
