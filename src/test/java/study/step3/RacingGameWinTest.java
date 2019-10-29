package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.RacingGameWin;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameWinTest {

    private RacingGameWin racingGameWin;
    private static final int TIME = 3;
    private static final String INPUT = "pobi,crong,honux";

    @BeforeEach
    void setUp() {
        racingGameWin = new RacingGameWin(TIME, INPUT);
    }

    @Test
    void initiateObjectTest() {
        assertThat(racingGameWin.initiateCar()).hasSize(3);
    }

    @Test
    void updatePositionTest() {
        assertThat(racingGameWin.initiateCar()).hasSize(3);
        assertThat(racingGameWin.updatePosition(1)).isBetween(1, 2);
    }

    @Test
    void moveCheckTest() {
        assertThat(racingGameWin.moveCheck()).isBetween(0, 1);
    }
}
