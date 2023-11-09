package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    public void create() {
        assertThatThrownBy(()-> new Position(-1)).isInstanceOf(RuntimeException.class);
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    public void move() {
        Position position = new Position();
        position.move();

        assertThat(position).isEqualTo(new Position(1));
    }
}