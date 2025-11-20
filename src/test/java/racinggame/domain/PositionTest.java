package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void create() {
        Position position = new Position(1);
        assertThat(position.value()).isEqualTo(1);
    }

    @Test
    void increase() {
        Position position = new Position(1);
        position.increase();
        assertThat(position.value()).isEqualTo(2);
    }

    @Test
    void isMaxPosition() {
        Position position = new Position(3);
        assertThat(position.isMaxPosition(3)).isTrue();
        assertThat(position.isMaxPosition(2)).isFalse();
    }

    @Test
    void max() {
        Position position = new Position(3);
        assertThat(position.max(2)).isEqualTo(3);
        assertThat(position.max(4)).isEqualTo(4);
    }
}
