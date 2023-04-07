package com.next.step.step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorValidationTest {

    @ParameterizedTest(name = "입력이 음수인 경우")
    @ValueSource(ints = {-1, -2, -100})
    void validateNegativeValue_음수인_경우(int input) {
        assertThatThrownBy(() -> StringCalculatorValidation.validateNegativeValue(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력에 음수 값이 포함되면 안됩니다.");
    }

    @ParameterizedTest(name = "입력이 숫자가 아닌 경우")
    @ValueSource(strings = {"a", "~", "/a"})
    void validateNumber_숫자가_아닌_경우(String input) {
        assertThatThrownBy(() -> StringCalculatorValidation.validateNumber(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 값이 입력돼 수정이 필요합니다.");
    }
}
