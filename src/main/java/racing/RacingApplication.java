package racing;

import racing.controller.RacingGame;
import racing.model.Racing;
import racing.view.Input;


public class RacingApplication {

    public static void main(String[] args) {
        String[] carNames = Input.getCarNames();
        int gameCount = Input.getGameCount();
        RacingGame racingGame = new RacingGame(gameCount);
        racingGame.gameStart(new Racing(carNames));
    }

}
