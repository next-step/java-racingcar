package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameVOTest {

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carNo() {
        assertThatThrownBy(() -> GameVO.validateInput(0, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_chanceNo() {
        assertThatThrownBy(() -> GameVO.validateInput(5, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ROUND_NUMBER_VALIDATION_ERROR);
    }
}
