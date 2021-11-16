package step5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarRacingGameTest {

    @Test
    void carRacingGame() {
        CarRacingGame carRacingGame = new CarRacingGame(3, new String[]{"kim", "lee"});
    }

    @Test
    void hasMoreRounds() {
        CarRacingGame carRacingGame = new CarRacingGame(1, new String[]{"kim", "lee"});
        assertTrue(carRacingGame.hasMoreRounds());

        carRacingGame.moveCars();
        assertFalse(carRacingGame.hasMoreRounds());
    }

    @Test
    void getWinners() {
        CarRacingGame carRacingGame = new CarRacingGame(3, new String[]{"kim", "lee"});
        assertEquals(2, carRacingGame.getWinners().size());
    }

    @Test
    void moveCars() {
        CarRacingGame carRacingGame = new CarRacingGame(3, new String[]{"kim", "lee"});
        assertEquals(3, carRacingGame.getRoundCount());

        carRacingGame.moveCars();
        assertEquals(2, carRacingGame.getRoundCount());
    }
}
