package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame = new RacingGame(1);

    @Test
    void generateRandomTest() {
        assertThat(racingGame.generateRandom()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "4:4:5"}, delimiter = ':')
    void moveForwardTest(int random, int before, int after) {
        assertThat(racingGame.moveForward(random, before)).isEqualTo(after);
    }
}
