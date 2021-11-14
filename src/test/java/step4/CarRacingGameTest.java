package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void init() {
        carRacingGame = new CarRacingGame(new String[]{"kim", "lee", "park"});
    }

    @Test
    void carCount() {
        assertEquals(3, carRacingGame.getCars().size());
    }

    @Test
    void isGameResultValid() {
        final int roundCount = 100;
        for (int i = 1; i <= roundCount; i++) {
            carRacingGame.moveCars();
            for (CarDTO car : carRacingGame.getCars()) {
                assertAll(
                    () -> assertThat(car.getPosition()).isLessThanOrEqualTo(roundCount),
                    () -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
                );
            }
        }
    }

    @Test
    void getWinners() {
        assertEquals(3, carRacingGame.getWinners().size());
    }
}
