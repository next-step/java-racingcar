package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @Test
    @DisplayName("생성 시 음수가 주어지면 예외 발생")
    void from_exception() {
        assertThatThrownBy(() -> TryCount.valueOf(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성 시 양수가 주어지면 정상 생성")
    void from() {
        TryCount tryCount = TryCount.valueOf(1);
        assertThat(tryCount.hasLeft()).isTrue();
    }

    @Test
    @DisplayName("decrement 호출하면 tryCount 1 감소")
    void decrement() {
        TryCount tryCount = TryCount.valueOf(2);
        tryCount.decrement();
        assertThat(tryCount.hasLeft()).isTrue();

        tryCount.decrement();
        assertThat(tryCount.hasLeft()).isFalse();
    }

    @Test
    @DisplayName("hasLeft 호출 시 tryCount가 1 이상이면 true 반환")
    void hasLeft() {
        TryCount tryCount = TryCount.valueOf(1);
        assertThat(tryCount.hasLeft()).isTrue();

        tryCount.decrement();
        assertThat(tryCount.hasLeft()).isFalse();
    }
}