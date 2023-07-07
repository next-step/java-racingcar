package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class TryCountTest {
    @Test
    void tryCountTest_valid() {
        TryCount tryCount = new TryCount("123");
        assertThat(tryCount).isEqualTo(new TryCount("123"));
    }

    @Test
    void tryCountTest_notValid() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryCount("ag"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryCount(""));
    }
}
