package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void init() {
        carRacingGame = new CarRacingGame(5, new String[]{"kim", "lee", "park"});
    }

    @Test
    void carCount() {
        assertEquals(3, carRacingGame.getCars().size());
    }

    @Test
    void isGameResultValid() {
        while (carRacingGame.hasMoreRounds()) {
            carRacingGame.moveCars();
        }
        assertThat(carRacingGame.getWinners().get(0).getPosition()).isLessThanOrEqualTo(5);
    }

    @Test
    void getWinners() {
        assertEquals(3, carRacingGame.getWinners().size());
    }
}
