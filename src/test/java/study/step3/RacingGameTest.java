package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    private static final int TIME = 3;
    private static final String INPUT = "pobi,crong,honux";

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, INPUT);
    }

    @Test
    void initiateObjectTest() {
        assertThat(racingGame.initiateCar(INPUT)).hasSize(3);
    }

    @Test
    void updatePositionTest() {
        assertThat(racingGame.initiateCar(INPUT)).hasSize(3);
        assertThat(racingGame.updatePosition(1)).isBetween(1, 2);
    }

    @Test
    void moveCheckTest() {
        assertThat(racingGame.moveCheck()).isBetween(0, 1);
    }
}
