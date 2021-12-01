package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void cache() {
        assertThat(p(99) == p(99)).isTrue();
        assertThat(p(100) == p(100)).isFalse();
        assertThat(Position.of(100)).isEqualTo(p(100));
    }

    @Test
    void move() {
        Position position = p(3);
        assertThat(position.movedPosition()).isEqualTo(p(4));
    }

    public static Position p(int position) {
        return Position.of(position);
    }
}
