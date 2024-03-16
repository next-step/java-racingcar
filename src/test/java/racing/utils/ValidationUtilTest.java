package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Constant;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.utils.ValidationUtil.validateInput;

class ValidationUtilTest {

    @Test
    @DisplayName("1이하의 자동차 대수의 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carNo() {
        assertThatThrownBy(() -> validateInput("name1", 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("0 이하의 라운드 수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_roundNo() {
        assertThatThrownBy(() -> validateInput("pobi, crong, honux", -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.ROUND_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("차 이름을 입력하지 않을 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carName_blank() {
        assertThatThrownBy(() -> validateInput(" ", 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("차 이름을 입력하지 않을 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carName_null() {
        assertThatThrownBy(() -> validateInput(null, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NUMBER_VALIDATION_ERROR);
    }

    @Test
    @DisplayName("5자 이상의 이름을 입력할 경우 RuntimeException 예외가 발생해야 한다")
    void validate_carName_length() {
        assertThatThrownBy(() -> validateInput("HarryPorter, SpongeBob", 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.CAR_NAME_LENGTH_VALIDATION_ERROR);
    }
}
