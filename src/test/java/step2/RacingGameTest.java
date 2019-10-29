package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private int numberOfCars = 5;
    private List<Integer> carFirstPositions = new ArrayList<>(Collections.nCopies(numberOfCars, 0));

    private RacingGame racingGame = new RacingGame(carFirstPositions);

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
        assertThat(racingGame.move()).hasSize(5);
        assertThat(racingGame.move().get(0)).isLessThanOrEqualTo(racingGame.move().get(0));
        assertThat(racingGame.move()).isInstanceOf(List.class);
    }
}
