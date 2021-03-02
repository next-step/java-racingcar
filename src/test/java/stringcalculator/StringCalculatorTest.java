package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5","12 + 5:17" }, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(String input,int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"223 - 220:3","12 - 5:7","3 - 34:-31" }, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtract(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3:6","12 * 2:24" ,"1234 * 223:275182"}, delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multiply(String input,int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2:2","123 / 21:5","2500 / 25:100" }, delimiter = ':')
    @DisplayName("난눗셈 테스트")
    void divide(String input,int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10","12 + 5 - 3 - 2 / 2 * 3:18" }, delimiter = ':')
    @DisplayName("복잡한 사칙연산 테스트")
    void combination(String input,int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null 일시 예외 테스트")
    void calculateThrowExceptionWhenInputIsNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력값이 빈 공백 문자 일시 예외 테스트")
    void calculateThrowExceptionWhenInputIsEmptyString(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 %%% 56", " 2 / 1 + 5 ** 7"})
    @DisplayName("입력값이 잘못된 사칙연산 기호 일시 예외 테스트")
    void calculateThrowExceptionWhenInputIsInvalidOperatorSymbol(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 56 + ", " 2 / 1 + 5 -", "2# / 5"})
    @DisplayName("입력값이 잘못된 형태 일때 예외 테스트")
    void calculateThrowExceptionWhenInputIsInvalidFormat(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(input);
        });
    }

}
