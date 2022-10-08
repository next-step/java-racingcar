package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarPositionTest {
    @Test
    @DisplayName("포지션에 값을 입력하면 포지션이 해당 값이 된다.")
    void createPositionTest_thenIsEqualTo() {
        CarPosition carPosition = new CarPosition(3);

        assertThat(carPosition).isEqualTo(new CarPosition(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -100})
    @DisplayName("포지션 값에 음수는 들어올 수 없다. 정지와 전진만 가능한 차이다")
    void valid(int input) {
        assertThatThrownBy(() -> new CarPosition(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션에 plus하면 포지션이 1변경 된다.")
    void move() {
        CarPosition carPosition = new CarPosition(3);

        assertThat(carPosition.plus()).isEqualTo(new CarPosition(4));
    }
}
