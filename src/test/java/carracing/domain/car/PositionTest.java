package carracing.domain.car;

import carracing.exception.RacingCarIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionTest {
    @DisplayName("기본 위치 값을 가지는 자동차를 생성할 수 있다.")
    @Test
    void create() {
        Position position = Position.create();
        assertThat(position).isEqualTo(Position.from(1));
    }

    @DisplayName("위치는 음수가 될 수 없다.")
    @Test
    void createWithNegative() {
        assertThatThrownBy(() -> Position.from(-1))
                .isInstanceOf(RacingCarIllegalArgumentException.class);
    }
    @DisplayName("자동차 위치에 1을 증가한 값을 반환 받을 수 있다.")
    @Test
    void increase() {

        Position position = Position.create();

        int result = position.increase();

        assertThat(result).isEqualTo(2);
    }


    @DisplayName("자동차 위치와 비교하는 숫자 중 더 큰 숫자를 반환할 수 있다.")
    @Test
    void createMaxPosition() {

        Position position = Position.create();
        Position otherPosition = Position.from(3);

        Position result = position.createMaxPosition(otherPosition);

        assertThat(result).isEqualTo(Position.from(3));
    }


}
