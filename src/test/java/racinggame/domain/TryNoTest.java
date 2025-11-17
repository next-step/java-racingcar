package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {
    @Test
    void isPositive() {
        assertThat(new TryNo(1).isPositive()).isTrue();
        assertThat(new TryNo(0).isPositive()).isFalse();
    }

    @Test
    void decrease() {
        assertThat(new TryNo(5).decrease()).isEqualTo(new TryNo(4));
    }

    @Test
    void create() {
        assertThat(new TryNo(5)).isEqualTo(new TryNo("5"));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> {
            new TryNo(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
