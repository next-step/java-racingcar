package racingcar.service.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PositionTest {
    @ParameterizedTest
    @DisplayName("값이 정상적인 경우")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void create(Integer number) {
        Position position = Position.from(number);
        assertThat(position).isEqualTo(Position.from(number));
    }

    @Test
    @DisplayName("값이 null인 경우 에러 발생 검증")
    void createException() {
        assertThatNullPointerException().isThrownBy(() -> Position.from(null));
    }

    @ParameterizedTest
    @DisplayName("값이 0보다 작은 경우 에러 발생 검증")
    @ValueSource(ints = {-1, -2, -3, -4})
    void createException2(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.from(number));
    }
}
