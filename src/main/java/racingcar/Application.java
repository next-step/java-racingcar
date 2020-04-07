package racingcar;

import racingcar.ui.RacingController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingController racingController = new RacingController(inputView);
        racingController.startGame();
    }
}
