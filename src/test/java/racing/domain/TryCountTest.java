package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TryCountTest {
    @Test
    void 시도기준_3_시도횟수_세번_true_반환() {
        TryCount tryCount = new TryCount(3);
        tryCount.increaseCount();
        tryCount.increaseCount();
        tryCount.increaseCount();

        assertThat(tryCount.isDone()).isTrue();
    }

    @Test
    void 시도기준_3_시도횟수_두번_false_반환() {
        TryCount tryCount = new TryCount(3);
        tryCount.increaseCount();
        tryCount.increaseCount();

        assertThat(tryCount.isDone()).isFalse();
    }

    @Test
    void 시도기준_3_시도횟수_네번_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            TryCount tryCount = new TryCount(3);
            tryCount.increaseCount();
            tryCount.increaseCount();
            tryCount.increaseCount();
            tryCount.increaseCount();
        });

    }
}
