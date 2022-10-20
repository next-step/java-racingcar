package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("position 값이 1 증가한다.")
    void move() {
        Position position = new Position();

        position.move();

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("position 값이 같으면 true를 반환한다.")
    void isSamePosition() {
        Position position = new Position();
        position.move();

        boolean actual = position.isSamePosition(1);

        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("position 값이 다르면 false 값을 반환한다.")
    void isSamePosition() {
        Position position = new Position();

        boolean actual = position.isSamePosition(1);

        assertThat(actual).isEqualTo(false);
    }
}
