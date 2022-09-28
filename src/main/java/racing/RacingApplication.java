package racing;

import racing.controller.RacingGame;
import racing.ui.InputViewImpl;
import racing.ui.ResultViewImpl;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputViewImpl(), new ResultViewImpl());
        racingGame.start();
    }

}
