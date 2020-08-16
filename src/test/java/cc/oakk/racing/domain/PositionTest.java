package cc.oakk.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @Test
    void construct_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }

    @Test
    void increase() {
        Position position = new Position(0).increase()
                .increase()
                .increase();

        assertThat(position.compareTo(new Position(4))).isEqualTo(0);
    }

    @Test
    void compareTo() {
        Position position = new Position(5);

        assertThat(position.compareTo(new Position(3))).isGreaterThan(0);
        assertThat(position.compareTo(new Position(5))).isEqualTo(0);
        assertThat(position.compareTo(new Position(8))).isLessThan(0);
    }
}
