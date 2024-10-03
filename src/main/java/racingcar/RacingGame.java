package racingcar;

import racingcar.controller.InputView;
import racingcar.controller.RacingController;
import racingcar.controller.ResultView;

public class RacingGame {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(InputView.getInstance(), ResultView.getInstance());
        racingController.play();
    }
}
