package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void increase() {
        assertThat(new Position(1).increase()).isEqualTo(new Position(2));
    }
}
