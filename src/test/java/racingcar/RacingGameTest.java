package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame();
    }

    @Test
    public void addTest() {
        int result = RacingGame.add(1);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void checkMoveTest() {
        boolean result = RacingGame.checkMove(4);
        assertThat(result).isTrue();
        result = RacingGame.checkMove(1);
        assertThat(result).isFalse();
    }

    @Test
    public void moveTest() {
        int[] carPositions = {0, 0, 0};
        int index = 1;
        int randomValue = 4;
        racingGame.move(carPositions, index, randomValue);
        assertThat(carPositions[index]).isEqualTo(1);
    }

    @Test
    public void randomValueTest() {
        int value = RacingGame.randomValue();
        assertThat(value).isBetween(0, 9);
    }
}