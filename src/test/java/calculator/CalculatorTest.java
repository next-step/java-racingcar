package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@DisplayName("사칙연산 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("덧셈")
    @ParameterizedTest(name="{displayName}: {0} + {1} = {2}")
    @CsvSource(value = {"1:2:3", "2:3:5"}, delimiter = ':')
    void add(int input1, int input2, int expected) {
        assertThat(calculator.add(input1,input2)).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest(name="{displayName}: {0} - {1} = {2}")
    @CsvSource(value = {"1:2:-1", "3:2:1"}, delimiter = ':')
    void subtract(int input1, int input2, int expected) {
        assertThat(calculator.subtract(input1,input2)).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest(name="{displayName}: {0} / {1} = {2}")
    @CsvSource(value = {"2:2:1", "6:2:3"}, delimiter = ':')
    void divide(int input1, int input2, int expected) {
        assertThat(calculator.divide(input1, input2)).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest(name="{displayName}: {0} * {1} = {2}")
    @CsvSource(value = {"2:2:4", "6:2:12"}, delimiter = ':')
    void multiply(int input1, int input2, int expected) {
        assertThat(calculator.multiply(input1, input2)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 전체: 3 + 5 - 2 * 2 / 3 = 4")
    @Test
    void calculateUsing4Operators() {
        assertThat(calculator.calculate("3 + 5 - 2 * 2 / 3")).isEqualTo(4);
    }

    @ParameterizedTest(name="입력에서 null이나 공백은 에러남: {0}")
    @ValueSource(strings = {"", " "})
    void userInputCanNotBeBlankStringOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.calculate(input)).withMessageMatching("사용자 입력은 null이거나 빈 공백 문자열일 수 없습니다.");
    }

    @ParameterizedTest(name="입력에서 사칙연산자외의 특수문자는 에러남: {0}")
    @ValueSource(strings = {"1 & 2", "1 $ 2"})
    void 입력에서_홀수번째_문자는_사칙연산자만_올_수_있다(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.calculate(input)).withMessageMatching("입력 값에서 홀수번째 문자는 사칙연산자만 가능합니다.");
    }

}
