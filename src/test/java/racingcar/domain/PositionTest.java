package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void move() {
        int startPosition = 5;
        Position position = new Position(startPosition);

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            position = position.move();
        }

        assertThat(position).isEqualTo(new Position(startPosition + moveCount));
    }

    @Test
    void equals() {
        assertThat(new Position(10)).isEqualTo(new Position(10));
    }

    @Test
    void compareTo() {
        assertThat(new Position(1000)).isGreaterThan(new Position(10));
        assertThat(new Position(10)).isEqualByComparingTo(new Position(10));
    }
}