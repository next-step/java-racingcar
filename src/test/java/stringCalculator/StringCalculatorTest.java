package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.exception.OperatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName(value = "문자열을 사칙연산 한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 * 2 * 2 * 2,16", "-1 * -1 / 2,0"})
    void stringCalculator(String str, int expected) {
        // given
        String source = str;

        // when
        int result = StringCalculator.calculator(source);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "연산자 추출 시 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "^"})
    void operatorException(String str) {

        // when
        assertThatThrownBy(() -> {
            StringCalculator.validateOperator(str);
            // then
        }).isInstanceOf(OperatorException.class)
                .hasMessage("사칙 연산자가 아닙니다.");
    }

    @DisplayName(value = "피연산자 추출 시 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"d", "a", "^"})
    void parseIntNumberFormException(String str) {

        // when
        assertThatThrownBy(() -> {
            StringCalculator.validateParseInt(str);
            // then
        }).isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자 형식의 문자열이 아닙니다.");
    }
}