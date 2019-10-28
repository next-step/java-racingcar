package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame = new RacingGame(1);

    @Test
    void calculatorTest() {
        assertThat(racingGame.generateRandom()).isBetween(0, 9);
    }
}
