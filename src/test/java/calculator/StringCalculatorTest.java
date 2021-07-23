package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("문자열 사칙 연산 계산기 테스트")
class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5 + 10 = 15", "10 + -5 = 5", "1 + 3 + 6 = 10", "10 + 100 + 500 = 610"}, delimiter = '=')
    void calculatorPlusTest(String input, int expected) {
        int actual = stringCalculator.arithmeticOperation(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("뺼셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 - 3 = 7", "10 - -5 = 15", "10 - 3 - 4 = 3", "1000 - 500 - 499 = 1"}, delimiter = '=')
    void calculatorMinusTest(String input, int expected) {
        int actual = stringCalculator.arithmeticOperation(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 * 3 = 30", "6 * -6 = -36", "10 * 3 * 4 = 120", "1000 * 10 * 10 = 100000"}, delimiter = '=')
    void calculatorMultiplyTest(String input, int expected) {
        int actual = stringCalculator.arithmeticOperation(input);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 / 2 = 5", "39 / 3 = 13", "1000 / 10 / 25 = 4", "1000 / 10 / 10 = 10"}, delimiter = '=')
    void calculatorDivideTest(String input, int expected) {
        int actual = stringCalculator.arithmeticOperation(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 때 IllegalArgumentException 발생 ")
    void calculatorEmptyExceptionTest() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> stringCalculator.arithmeticOperation(null)
                ),
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> stringCalculator.arithmeticOperation("")
                ),
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> stringCalculator.arithmeticOperation(" ")
                ),
                () -> assertThatIllegalArgumentException().isThrownBy(
                        () -> stringCalculator.arithmeticOperation("   ")
                )
        );
    }

    @DisplayName("사칙연산 기호가 아닌경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"20 + +", "10 + *", "+ 10", "ADD 10", "10 X 20", "10", "+"})
    void calculatorExceptionTest(String param) {
        assertThatThrownBy(() -> stringCalculator.arithmeticOperation(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid value");
    }

    @DisplayName("사칙 연산 모두 포함하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 + 5 - 3 * 2 / 2 = 12", "20 * 6 / 6 - 10 = 10", "10 + 10 / 5 - 7 * 2  = -6"}, delimiter = '=')
    void calculatorCombineTest(String input, int expected) {
        int actual = stringCalculator.arithmeticOperation(input);
        assertThat(actual).isEqualTo(expected);
    }

}