package carracing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @Test
    void create_success() {
        assertThat(new TryCount(5)).isEqualTo(new TryCount(5));
    }

    @Test
    void create_fail_negative() {
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void consume_fail_zero() {
        TryCount zero = new TryCount(0);
        assertThatThrownBy(() -> zero.consume())
                .isInstanceOf(IllegalArgumentException.class);
    }
}