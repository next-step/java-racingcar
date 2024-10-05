package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.GameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("음수 위치가 입력되면 예외가 발생한다.")
    @Test
    void positionGenerationExceptionTest() {
        int location = -1;

        assertThatThrownBy(() -> Position.of(location))
                .isInstanceOf(GameException.class)
                .hasMessage("음수를 허용하지 않습니다.");
    }

    @DisplayName("입력되는 값과 비교해서 더 큰 값을 반환한다.")
    @Test
    void maxPositionTest() {
        Position position = Position.of(3);

        assertThat(position.max(4)).isEqualTo(4);
        assertThat(position.max(2)).isEqualTo(3);
    }

    @DisplayName("입력되는 값과 비교해서 더 큰 값을 반환한다.")
    @Test
    void isSameTest() {
        Position position = Position.of(3);

        assertThat(position.isSame(4)).isFalse();
        assertThat(position.isSame(3)).isTrue();
    }
}