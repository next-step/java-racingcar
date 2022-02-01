package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = RacingController.getInstance(InputView.setNames(), InputView.setTurnCount().getValue());
        racingController.start();
        racingController.printGameResult();
    }
}