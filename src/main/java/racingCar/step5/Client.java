package racingCar.step5;

import racingCar.step5.view.RacingCarGameController;

public class Client {
    public static void main(String[] args) {
        RacingCarGameController gameController = new RacingCarGameController();
        gameController.gameStart();
    }
}
