package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame();
    }

    @Test
    public void moveTest() {
        racingGame.move();

        assertThat(racingGame.getCars().get(0).getPosition()).isNotEqualTo(0);
        assertThat(racingGame.getCars().get(1).getPosition()).isNotEqualTo(0);
        assertThat(racingGame.getCars().get(2).getPosition()).isNotEqualTo(0);
    }
}