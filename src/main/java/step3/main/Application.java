package step3.main;

import step3.service.GameStrategy;
import step3.service.RacingCarForwardMatcher;
import step3.service.RacingCarGame;

public class Application {

    public static void main(String[] args) {
        GameStrategy game = new RacingCarGame(new RacingCarForwardMatcher());

        game.start();
    }

}
