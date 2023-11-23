package step4;

import step4.controller.CarRacingController;
import step4.view.InputView;

public class RacingCarGameApplication {
    public static void main(String[] args) {
        CarRacingController.startGame(InputView.inputCarName(), InputView.inputRoundCount());
    }
}
