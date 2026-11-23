package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class TryCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("0 이하로 생성하면 IllegalArgumentException")
    void throwsExceptionWhenNotPositive(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryCount(count))
                .withMessage("try count must be positive [" + count + "]");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("0보다 크면 회차를 진행할 수 있다")
    void hasRemainingWhenPositive(int count) {
        TryCount tryCount = new TryCount(count);

        assertThat(tryCount.hasRemaining()).isTrue();
    }

    @Test
    @DisplayName("한 회차가 진행되면 1 감소한다")
    void decreaseByOne() {
        TryCount tryCount = new TryCount(2);

        tryCount.decrease();

        assertThat(tryCount.hasRemaining()).isTrue();
    }

    @Test
    @DisplayName("0이 되면 회차를 진행할 수 없다")
    void noRemainingWhenZero() {
        TryCount tryCount = new TryCount(1);

        tryCount.decrease();

        assertThat(tryCount.hasRemaining()).isFalse();
    }

    @Test
    @DisplayName("0일 때 감소하면 IllegalStateException")
    void throwsExceptionWhenDecreaseAtZero() {
        TryCount tryCount = new TryCount(1);
        tryCount.decrease();

        assertThatIllegalStateException().isThrownBy(tryCount::decrease)
                .withMessage("no remaining try count");
    }
}
