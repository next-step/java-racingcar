package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @Test
    @DisplayName("position의 value가 양수가 아니면, IllegalArgumentException을 던진다")
    void should_throw_Illegal_argument_exception_when_position_is_negative_quantity() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("position is not available");
    }
}
