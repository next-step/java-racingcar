package racingcar;

import racingcar.contoller.RacingCarController;

public class Application {

    private static RacingCarController racingCarController = new RacingCarController();


    public static void main(String[] args) {
        racingCarController.startGame();
    }
}
