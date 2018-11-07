package racingcar;

import org.junit.Test;

import racingcar.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    static final int TESTDATA = 3;
    private int[] carPositions = {0,0,0};

    @Test
    public void draw() {
        String result = RacingGame.drawLine(TESTDATA);
        assertThat(result).isEqualTo("---");
    }
    @Test
    public void limit() {
        RacingGame rg = new RacingGame();
        assertThat(rg.checkLimit(4)).isEqualTo(1);
    }

}