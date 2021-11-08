package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static step2.Operator.VALID_REQUIRED_ARITHMETIC_MSG;
import static step2.Validation.VALID_ARITHMETHIC_INPUT_SIZE;
import static step2.Validation.VALID_NULL_EMPTY_CHECK_MSG;

class CalculatorTest {

    @Test
    void 덧셈() {
        assertThat(Calculator.calculate("3 + 4")).isEqualTo(7);
    }

    @Test
    void 뺼셈() {
        assertThat(Calculator.calculate("8 - 4")).isEqualTo(4);
    }

    @Test
    void 곱셈() {
        assertThat(Calculator.calculate("3 * 4")).isEqualTo(12);
    }

    @Test
    void 나눗셈() {
        assertThat(Calculator.calculate("20 / 5")).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 입력값이_Null_또는_빈공백(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.calculate(input);
        }).withMessageMatching(VALID_NULL_EMPTY_CHECK_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7 * 2 + 3 /", "3 +  ", "2 * 1 -", "3 * 2 +"})
    void 입력값의_개수가_정상이아닐경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        }).withMessageMatching(VALID_ARITHMETHIC_INPUT_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2 2", "2 ( 3", "3 * 4 $ 3"})
    void 입력값의_사칙연산이_잘못될경우(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        }).withMessageMatching(VALID_REQUIRED_ARITHMETIC_MSG);
    }

}