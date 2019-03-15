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
        String[] carsName = InputValue.getCarsName();
        int racingCount = InputValue.getRacingCount();

        RacingGame racingGame = new RacingGame(carsName, racingCount);
        GameResult result = null;

        while ( racingGame.isRunning() ) {
            result = racingGame.playingGame();
            ResultView.printGame(result);
        }

        ResultView.printGameWinner(result);
    }
}
