package step2.racing_mvc;

import step2.racing_mvc.controller.RacingGameController;

public class RacingApplication {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.start();
    }
}