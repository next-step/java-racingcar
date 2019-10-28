package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @Test
    void iterateCarMoveTest() {
        assertThat(racingGame.iterateCarMove(3)).isBetween(3, 4);
    }

    @Test
    void moveTest() {
        RacingGame racingGameForMoveTest = new RacingGame(3);
        assertThat(racingGameForMoveTest.move()).hasSize(3);
        assertThat(racingGameForMoveTest.move()).isInstanceOf(List.class);
    }
}
