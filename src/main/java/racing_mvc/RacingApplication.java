package racing_mvc;

import racing_mvc.controller.RacingGameController;

public class RacingApplication {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.start();
    }
}
