package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("위치값을 생성한다. 초기값으로 음수 전달시 예외가 발생한다")
    public void create() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(RuntimeException.class);
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("위치값을 이동한다. 위치값이 1 증가한다")
    public void move() {
        Position position = new Position();
        position.move();

        assertThat(position).isEqualTo(new Position(1));
    }
}