package study.racingcar;

import study.racingcar.controller.RandomGameController;

public class MainApplication {
    public static void main(String[] args) {
        RandomGameController randomGameController = new RandomGameController();
        randomGameController.start();
    }
}
