package racing.model;

import exception.InvalidPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("위치가 음수일때 Exception확인")
    void negativePosition() {
        assertThatThrownBy(() -> {
            Position position = new Position(-1);
        }).isInstanceOf(InvalidPositionException.class);
    }

    @Test
    @DisplayName("위치가 제대로 생성되었는지 확인")
    void checkPosition() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("위치가 제대로 움직였는지 확인")
    void move() {
        Position position = new Position();
        position.move();
        position.move();
        position.move();
        assertThat(position).isEqualTo(new Position(3));
    }
}