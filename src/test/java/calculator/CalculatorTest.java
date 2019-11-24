package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("1.1. 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void validateNullArgs(String args) throws IllegalArgumentException {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.run(args);
        }).withMessage("문자열이 입력되지 않았습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 $ 3 * 4 / 2"})
    @DisplayName("1.2. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void validateOddTextOperatorArgs(String args) throws IllegalArgumentException {
        String[] arg = args.split(" ");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.run(args);
        }).withMessage("올바르지 않은 연산자가 입력되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + "})
    @DisplayName("1.3. 입력받는 값은 값의 크기는 3보다 크고, 홀수개의 값이다.")
    void validateTextFormatArgs(String args) throws IllegalArgumentException {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.run(args);
        }).withMessage("올바르지 않은 연산자가 입력되었습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3"}, delimiter = ',')
    @DisplayName("2.1. 덧셈")
    void plus(long first, long second) {
        Long result = calculator.plus(first, second);
        System.out.println(result);
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3"}, delimiter = ',')
    @DisplayName("2.2. 뺄셈")
    void minus(long first, long second) {
        Long result = calculator.minus(first, second);
        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,4"}, delimiter = ',')
    @DisplayName("2.3. 곱셈")
    void multiply(long first, long second) {
        Long result = calculator.multiply(first, second);
        assertThat(result).isEqualTo(12);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,2"}, delimiter = ',')
    @DisplayName("2.4. 나눗셈")
    void divide(long first, long second) {
        Long result = calculator.divide(first, second);
        assertThat(result).isEqualTo(2);

    }
}