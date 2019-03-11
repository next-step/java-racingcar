package racinggame;

import org.junit.Test;
import racinggame.Controller.RacingGame;

import static utils.GenerateRandom.generatingRandomNumber;

public class RacingGameTest {
    RacingGame racing = new RacingGame();
    public final int RANDOM_RANGE = 10;

    @Test
    public void racingGame() {
        int countCar = generatingRandomNumber(RANDOM_RANGE);
        int countGame = generatingRandomNumber(RANDOM_RANGE);
        racing.game(countCar, countGame);
    }
}