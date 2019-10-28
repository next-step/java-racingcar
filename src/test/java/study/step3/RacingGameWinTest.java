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
}
