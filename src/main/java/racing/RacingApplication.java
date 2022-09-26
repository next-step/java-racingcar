package racing;

import racing.controller.RacingGame;
import racing.ui.InputViewImpl;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputViewImpl());
        racingGame.start();
    }

}
