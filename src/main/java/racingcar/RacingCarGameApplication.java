package racingcar;

import racingcar.controller.GameController;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        GameController gameController = applicationContext.getGameController();
        gameController.start();
    }
}
