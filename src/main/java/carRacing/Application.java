package carRacing;

import carRacing.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.runGame();
    }
}
