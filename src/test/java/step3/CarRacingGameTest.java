package step3;

import org.junit.jupiter.api.Test;

public class CarRacingGameTest {
    @Test
    public void carRacingGameTest() {
        CarRacingGame carRacingGame = new CarRacingGame(5, 3);
        carRacingGame.doGame();
    }
}