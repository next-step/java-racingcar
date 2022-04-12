package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("move 호출 횟수로 동등성 비교")
    @Test
    void move() {
        Position position = new Position();

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            position = position.move();
        }

        assertThat(position).isEqualTo(new Position(3));
    }
}