package racingcar;


import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.start();
    }
}
