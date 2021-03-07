package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study.step2.validation.CalculatorValidator;

public class CalculatorValidatorTest {
    @Test
    @DisplayName("Null 테스트")
    void inputNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalculatorValidator.validateEmpty(null));
    }

    @ParameterizedTest(name = "빈값 테스트")
    @ValueSource(strings = {"", "  "})
    void inputEmpty(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalculatorValidator.validateEmpty(input));
    }

    @ParameterizedTest(name = "숫자 유효성 테스트 - 1")
    @ValueSource(strings = {"1", "2", "3"})
    void validNumber(String input) {
        assertThat(CalculatorValidator.validateStringToNumber(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest(name = "숫자 유효성 테스트 - 1")
    @ValueSource(strings = {"3g", "dd", "10-0"})
    void validNumberException(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CalculatorValidator.validateStringToNumber(input));
    }


}
