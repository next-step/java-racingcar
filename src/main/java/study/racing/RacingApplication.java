package study.racing;

import study.racing.controller.RacingController;
import study.racing.view.InputView;
import study.racing.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingController controller = new RacingController(
                new OutputView(),
                new InputView()
        );

        controller.startGame();
    }
}
