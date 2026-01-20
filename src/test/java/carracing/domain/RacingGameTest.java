package carracing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @Test
    @DisplayName("게임결과")
    void play() {
        RacingGame racingGame = new RacingGame("kim,lee", 1);
        racingGame.play(() -> 4);
        assertThat(racingGame.isEnd()).isFalse();
    }
}