package racing;

import racing.controller.RacingGame;
import racing.model.Racing;
import racing.view.InputView;


public class RacingApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int gameCount = InputView.getGameCount();
        RacingGame racingGame = new RacingGame(gameCount);
        racingGame.gameStart(new Racing(carNames));
    }

}
