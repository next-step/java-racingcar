package edu.nextstep.camp.racinggame.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @Test
    public void create() {
        Position position = Position.ofZero();
        assertThat(position.toInt()).isEqualTo(0);
        assertThat(position).isEqualTo(Position.of(0));
    }

    @Test
    public void createFailed() {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.of(-1));
    }

    @Test
    public void move() {
        Position position = Position.ofZero();
        Position newPosition = position.forward();
        assertThat(position).isEqualTo(Position.ofZero());
        assertThat(newPosition).isEqualTo(Position.of(1));
    }

    @Test
    public void compare() {
        Position position1 = Position.of(1);
        Position position2 = Position.ofZero();
        assertThat(position1).isInstanceOf(Comparable.class);
        assertThat(position1.compareTo(position2)).isGreaterThan(0);
        assertThat(position2.compareTo(Position.ofZero())).isEqualTo(0);
        assertThat(position2.compareTo(position1)).isLessThan(0);
    }
}
