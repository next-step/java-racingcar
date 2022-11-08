package carracing;

import carracing.controller.RacingGameController;

public class RacingMain {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.run();
    }
}
