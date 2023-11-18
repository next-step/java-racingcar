package car;

import car.controller.GameController;
import car.model.RandomNumberGenerator;

public class CarApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RandomNumberGenerator());
        gameController.startRacingGame();
    }
}
