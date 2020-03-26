package study.racingcar;

import study.racingcar.controller.RacingGameController;

public class MainApplication {
    public static void main(String[] args) {
        RacingGameController randomGameController = new RacingGameController();
        randomGameController.start();
    }
}
