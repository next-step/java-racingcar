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

    @DisplayName("GameCount가 양수이면 true 반환한다")
    @Test
    void gameCountIsPositive() {
        assertThat(new GameCount(1).isPositive()).isTrue();
    }

    @DisplayName("GameCount가 1 감소하여 0이 되면 isPositive는 false 반환")
    @Test
    void gameCountIsPositive_whenZeroAfterDecrease() {
        GameCount count = new GameCount(1);
        GameCount decreased = count.decrease();
        assertThat(decreased.isPositive()).isFalse();
    }

    @DisplayName("GameCount 가 1회 감소한다")
    @Test
    void gameCountDecrease() {
        assertThat(new GameCount(2).decrease()).isEqualTo(new GameCount(1));
    }
}