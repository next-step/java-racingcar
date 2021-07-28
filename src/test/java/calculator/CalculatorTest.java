package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


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

}
