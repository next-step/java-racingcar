package car;

import car.entity.RacingGame;
import car.util.InputValue;

public class RacingGameApplication {

    public static void main(String args[]) {
        RacingGameApplication.startGame();
    }

    public static void startGame() {
        int carCount = InputValue.getCarCount();
        int tryCount = InputValue.getTryCount();

        RacingGame racingGame = new RacingGame(carCount, tryCount);
        racingGame.gameStart(tryCount);
    }
}
