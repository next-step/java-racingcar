package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TryCountTest {

    @Test
    void 시도횟수는_1회_이상이어야_한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new TryCount(0));
    }

    @Test
    void 차를_한번씩_움직이고_시도횟수는_1씩_감소한다() {
        TryCount tryCount = new TryCount(3);
        for (int i = 0; i < 3; i++) {
            tryCount.decreaseTryCount();
        }
        assertThat(tryCount.isPlaying()).isEqualTo(false);
    }
}
