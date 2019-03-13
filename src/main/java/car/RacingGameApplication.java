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
        int tryCount = InputValue.getTryCount();

        RacingGame racingGame = new RacingGame(carsName);
        GameResult result = new GameResult();

        int i =0;
        while (i < tryCount) {
            result = racingGame.playingGame();
            ResultView.printGame(result);
            i ++;
        }

        ResultView.printGameWinner(result);
    }
}
