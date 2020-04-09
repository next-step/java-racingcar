package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void isRaceEnd() {
        String[] names = {"a", "b", "c"};
        RacingGame racingGame = new RacingGame(names, 0);
        assertThat(racingGame.isRaceEnd()).isTrue();
    }

}