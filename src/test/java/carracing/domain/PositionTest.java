package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("자동차 생성시 위치는 0이다")
    void newPosition() {
        assertThat(new Position().value()).isEqualTo(0);
    }

    @Test
    @DisplayName("생성 후 움직이면 position이 증가한다")
    void move() {
        Position position = new Position();
        Position movedPosition = position.move();
        assertThat(movedPosition.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 위치면 같은 값을 가지고 있다")
    void samePosition() {
        assertThat(new Position(3)).isEqualTo(new Position(3));
    }
}