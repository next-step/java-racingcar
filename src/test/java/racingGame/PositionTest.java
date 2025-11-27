package racingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("음수 위치로 생성하면 예외가 발생한다")
    void negativePosition_throwsException() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("move()를 호출하면 위치가 1 증가한 새로운 Position을 반환한다")
    void move_returnsNewPositionPlusOne() {
        Position position = new Position(2);

        Position next = position.move();

        assertThat(next.value()).isEqualTo(3);
        assertThat(position.value()).isEqualTo(2);
    }

    @Test
    @DisplayName("max는 현재 값과 전달된 값 중 더 큰 값을 반환한다")
    void max_returnsGreaterValue() {
        Position position = new Position(3);

        int max1 = position.max(1);
        int max2 = position.max(5);

        assertThat(max1).isEqualTo(3);
        assertThat(max2).isEqualTo(5);
    }

    @Test
    @DisplayName("isSame은 동일한 값이면 true, 아니면 false를 반환한다")
    void isSame_comparesValueCorrectly() {
        Position position = new Position(3);

        assertThat(position.isSame(3)).isTrue();
        assertThat(position.isSame(2)).isFalse();
    }
}
