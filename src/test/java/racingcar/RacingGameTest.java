package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {
    RacingGame racingGame = new RacingGame();

    @Test
    public void 레이싱카_생성() {
        this.racingGame.setCar(2);
        assertThat(this.racingGame.racingCars.size()).isEqualTo(2);
    }
}