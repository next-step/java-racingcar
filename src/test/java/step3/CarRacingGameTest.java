package step3;

import org.junit.jupiter.api.Test;

public class CarRacingGameTest {

    @Test
    void carRacingGame() throws Exception {
        CarRacingGame carRacingGame = new CarRacingGame(1, 1);
        carRacingGame.start();
    }
}
