package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

    @Test
    void create () {
        Position position = new Position(2);
        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void valid () {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Position(-1))
                .withMessageMatching("position은 0보다 커야 합니다.");
    }

    @Test
    void go () {
        Position position = new Position(2);
        position = position.move();
        assertThat(position).isEqualTo(new Position(3));
    }
}