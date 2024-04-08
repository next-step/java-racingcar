package step5;

import step5.controller.RacingController;
import step5.domain.RacingGame;
import step5.view.InputView;
import step5.view.ResultView;

public class Main {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.racingGame();
    }
}
