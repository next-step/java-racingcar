package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TryCount;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @Test
    void create() {
        assertThatNoException().isThrownBy(()->new TryCount("123"));
    }

    @Test
    void tryCountTest_valid() {
        TryCount tryCount = new TryCount("123");
        assertThat(tryCount).isEqualTo(new TryCount(123));
    }

    @Test
    void tryCountTest_notValid() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryCount("ag"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryCount(""));
    }

    @Test
    void isNotZero() {
        assertThat(new TryCount(123).isNotZero()).isTrue();
        assertThat(new TryCount(0).isNotZero()).isFalse();
    }

    @Test
    void minus() {
        assertThat(new TryCount(123).minus()).isEqualTo(new TryCount(122));
    }
}
