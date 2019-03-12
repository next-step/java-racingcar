package car;

import car.entity.RacingGame;
import car.entity.GameResult;
import car.util.InputValue;
import car.entity.ResultView;

public class RacingGameApplication {

    public static void main(String args[]) {
        RacingGameApplication.startGame();
    }

    public static void startGame() {
        int carCount = InputValue.getCarCount();
        int tryCount = InputValue.getTryCount();

        RacingGame racingGame = new RacingGame(carCount);
        GameResult result = racingGame.playingGame(tryCount);
        ResultView.printAllGame(result);
    }
}
