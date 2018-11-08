package racingcar;

import org.junit.Test;

import racingcar.RacingGame.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    static final int TESTDATA = 3;

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
    @Test
    public void compare() {
        RacingGame rg = new RacingGame();
        assertThat(rg.compareNum(7, 4)).isEqualTo(7);
    }
}