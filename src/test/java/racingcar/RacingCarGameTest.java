package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void isEnd() {
        RacingCarGame racingCarGame = new RacingCarGame(3, 1);
        assertThat(racingCarGame.isEnd()).isFalse();

        racingCarGame.play(() -> true);
        assertThat(racingCarGame.isEnd()).isTrue();
    }

}
