package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Test
    public void moveTest() {
        int[] carPositions = {0, 0, 0};
        int time = 1;
        int index = 1;
        int randomValue = 4;
        racingGame = new RacingGame(carPositions, time);
        racingGame.move(index, randomValue);
        assertThat(carPositions[index]).isEqualTo(1);
    }
}