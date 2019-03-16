package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void racingGameTest() {
        this.racingGame = new RacingGame("shin, yeon, jong");
    }

    @Test
    public void createRacingCar() {
        assertThat(this.racingGame.getRacingCar().size()).isEqualTo(3);
    }
}