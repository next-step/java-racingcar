package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.Car;
import step3.CarRacingGame;

public class CarRacingGameTest {

    private step3.CarRacingGame carRacingGame;

    @BeforeEach
    void init() {
        carRacingGame = new step3.CarRacingGame(3);
    }

    @Test
    void carCountTest() {
        assertEquals(3, carRacingGame.getCars().length);
    }

    @Test
    void isGameResultValidTest() {
        final int roundCount = 100;
        for (int i = 1; i <= roundCount; i++) {
            carRacingGame.moveCars();
            for (Car car : carRacingGame.getCars()) {
                assertAll(
                    () -> assertThat(car.getPosition()).isLessThanOrEqualTo(roundCount),
                    () -> assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
                );
            }
        }
    }

    @Test
    void carRacingGameFailBecauseCarCountIsLessOrEqualsThan0() {
        assertThatThrownBy(() -> new CarRacingGame(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
