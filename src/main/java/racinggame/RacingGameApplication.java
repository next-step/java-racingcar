package racinggame;

import racinggame.controller.CarGameController;

public class RacingGameApplication {
    public static void main(String[] args) {
        CarGameController carGameController = CarGameController.getInstance();
        carGameController.playGame();
    }
}
