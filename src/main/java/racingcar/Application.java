package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(InputView.names(), InputView.turn().getValue());
        racingController.start();
        racingController.printGameResult();
    }
}