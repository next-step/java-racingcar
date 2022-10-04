package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void testTryGame() {
        RacingGame racingGame = new RacingGame() {
            @Override
            protected boolean isMovable() {
                return true;
            }
        };

        racingGame.createCars(1);
        racingGame.tryGame();
        racingGame.tryGame();
        racingGame.tryGame();

        assertThat(racingGame.getCars().get(0).getPosition()).isEqualTo(3);
    }
}
