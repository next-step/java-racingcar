package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    void isEnd() {
        RacingCarGame racingCarGame = new RacingCarGame(new String[]{"carA", "carB"}, 1);
        assertThat(racingCarGame.isEnd()).isFalse();

        racingCarGame.play(() -> true);
        assertThat(racingCarGame.isEnd()).isTrue();
    }

}
