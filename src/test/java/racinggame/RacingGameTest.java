package racinggame;

import org.junit.Test;
import racinggame.Controller.RacingGame;

public class RacingGameTest {
    RacingGame racing = new RacingGame();

    @Test
    public void racingGame() {
        int countCar= (int)(Math.random() * 10);
        int countGame = (int)(Math.random() * 10);
        racing.game(countCar, countGame);
    }
}