package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void createPositionTest() {
        int expected = 1;
        Position position = new Position(expected);
        Assertions.assertThat(position.position()).isEqualTo(expected);
    }

    @Test
    void addTest() {
        int initialPosition = 0;
        int steps = 3;
        Position position = new Position(initialPosition);
        position.add(steps);
        Assertions.assertThat(position.position()).isEqualTo(initialPosition + steps);
    }

    @Test
    void copyTest() {
        int initialPosition = 0;
        Position position = new Position(initialPosition);
        Position copy = position.copy();

        Assertions.assertThat(copy.position()).isEqualTo(initialPosition);
        Assertions.assertThat(copy).isNotSameAs(position);
    }
}