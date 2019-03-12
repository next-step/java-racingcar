package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void racingGameTest() {
        this.racingGame = new RacingGame(3, 3);
    }

    @Test
    public void createCarTest() {
        assertThat(this.racingGame.racingCars.size()).isEqualTo(3);
    }
}