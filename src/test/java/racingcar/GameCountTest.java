package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCountTest {

    @DisplayName("게임 횟수 정상 생성된다")
    @Test
    void createGameCount() {
        assertThat(new GameCount(1).asInt()).isEqualTo(1);
    }

    @DisplayName("게임 횟수가 1 미만이면 예외 발생한다")
    @Test
    void gameCountValidation() {
        assertThatThrownBy(() -> new GameCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 횟수");
    }
}