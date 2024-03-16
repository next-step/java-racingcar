package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;
import racing.dto.GameVO;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racing.utils.ValidationUtil.validateInput;

class ValidationUtilTest {

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carNo() {
        GameVO gameVO = new GameVO(new String[]{}, 5);
        assertThatThrownBy(() -> validateInput(gameVO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("음수 또는 0을 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_chanceNo() {
        GameVO gameVO = new GameVO(new String[]{"pobi", "crong", "honux"}, -1);
        assertThatThrownBy(() -> validateInput(gameVO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ROUND_NUMBER_VALIDATION_ERROR);
    }

}
