package carracing;

import carracing.controller.CarRacingGameController;

public class Application {
    public static void main(String[] args) {
        CarRacingGameController carRacingGameController = new CarRacingGameController();
        carRacingGameController.run();
    }
}
