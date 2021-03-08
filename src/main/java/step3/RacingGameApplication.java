package step3;

import step3.module.CarRacingGame;
import step3.module.RacingGameRunnable;

/**
 * 레이싱 게임 Application
 */
public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameRunnable racingGame = new CarRacingGame();
        racingGame.run();
    }
}
