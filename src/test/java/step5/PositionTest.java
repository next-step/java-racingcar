package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    void position() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void increase() {
        Position increased = new Position(0).increase();
        assertThat(increased).isEqualTo(new Position(1));
    }

    @Test
    void invalidPositionExceptionBecausePositionLessThan0() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(InvalidPositionException.class);
    }

    @Test
    void equals() {
        assertThat(new Position(0)).isEqualTo(new Position(0));
    }

    @Test
    void compareTo() {
        assertThat(new Position(1).compareTo(new Position(0))).isGreaterThan(0);
    }
}
