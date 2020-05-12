package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("자동차 대수와 이동 횟수가 0 보다 같거나 작으면 IllegalArgumentException 발생한다.")
    @Test
    void createRacingGame_fail() {
        assertThatThrownBy(() -> new RacingGame(0, 0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RacingGame(-1, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 대수와 이동 횟수가 0보다 크면 정상적으로 생성된다.")
    @Test
    void createRacingGame_success() {
        assertThat(new RacingGame(1, 1)).isNotNull();
    }
}
