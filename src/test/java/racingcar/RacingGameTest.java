package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {

    @Test
    public void setCarsTest() {
        RacingGame racingGame = new RacingGame(2, 2);
        assertThat(racingGame.racingCars.size()).isEqualTo(2);
    }
}