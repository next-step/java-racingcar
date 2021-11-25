package step5;

import step5.controller.CarRacingController;
import step5.domain.CarRacingGame;

public class Application {

    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController();
        CarRacingGame carRacingGame = carRacingController.createGame();
        carRacingController.play(carRacingGame);
        carRacingController.drawResult(carRacingGame);
    }

}
