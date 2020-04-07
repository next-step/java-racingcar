package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void isRaceEnd() {
        RacingGame racingGame = new RacingGame("a,b,c", 0);
        assertThat(racingGame.isRaceEnd()).isTrue();
    }

}