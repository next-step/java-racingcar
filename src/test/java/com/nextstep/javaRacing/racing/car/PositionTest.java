package com.nextstep.javaRacing.racing.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void create() {
        Position position = new Position(5);
        assertThat(position.get()).isEqualTo(5);
    }

    @Test
    public void compare() {
        Position smaller = new Position(0);
        Position larger = new Position(1);
        assertThat(smaller.compareTo(larger)).isLessThan(0);
    }

    @Test
    public void equals() {
        Position position1 = new Position(4);
        Position position2 = new Position(4);
        assertThat(position1).isEqualTo(position2);
    }
}
