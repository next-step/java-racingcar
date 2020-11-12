package racingcar;

import racingcar.controller.RacingGameController;

public class RacingGame {

    private RacingGameController racingGameController;

    public RacingGame() {
        this.racingGameController = new RacingGameController();
    }

    public void startRacingGame() {
        racingGameController.startRacingGame();
    }

    public void createCar() {
        racingGameController.createCar();
    }

    public void readyGame() {
        racingGameController.readyGame();
    }

    public void race() {
        racingGameController.startGame();
    }


    public void run() {
        racingGameController.startRacingGame();

        racingGameController.enterCars();

        racingGameController.startGame();
        racingGameController.racingResult();
    }
}
