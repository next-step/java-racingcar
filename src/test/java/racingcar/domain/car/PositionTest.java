package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    void constructor() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}
