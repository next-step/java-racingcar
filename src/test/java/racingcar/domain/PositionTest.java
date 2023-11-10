package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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