package step3;

import step3.controller.CarGameController;

public class CarGame {
    private static final CarGameController carGameController = new CarGameController();

    public static void main(String[] args) {
        carGameController.run();
    }
}