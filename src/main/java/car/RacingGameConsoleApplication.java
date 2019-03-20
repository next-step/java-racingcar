package car;

import car.domain.RacingGame;
import car.domain.GameResult;
import car.view.InputValue;
import car.view.ResultView;

public class RacingGameConsoleApplication {

    public static void main(String args[]) {
        RacingGameConsoleApplication.startGame();
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
