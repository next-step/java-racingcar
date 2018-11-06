package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame("a,b,c");
    }

    @Test
    public void moveTest() {
    }
}