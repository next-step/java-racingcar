package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "4 + 8:12", "102 + 106:208"}, delimiter = ':')
    @DisplayName("덧셈 테스트")
    void add(String input, String expected) {
        int expectedValue = Integer.parseInt(expected);

        final int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 - 3:7", "3 - 142:-139", "1042 - 102:940"}, delimiter = ':')
    @DisplayName("뺄셈 테스트")
    void subtract(String input, String expected) {
        int expectedValue = Integer.parseInt(expected);

        final int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 * 7:21", "4 * 12:48", "-12 * 9:-108"}, delimiter = ':')
    @DisplayName("곱셈 테스트")
    void multiply(String input, String expected) {
        int expectedValue = Integer.parseInt(expected);

        final int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"21 / 3:7", "48 / 4:12", "-108 / -12:9"}, delimiter = ':')
    @DisplayName("나눗셈 테스트")
    void divide(String input, String expected) {
        int expectedValue = Integer.parseInt(expected);

        final int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 * 4 / 2 + 7 - 3:14", "4 - 2 / 2 * 7 + 3:10"}, delimiter = ':')
    @DisplayName("사칙 연산을 모두 포함하는 테스트")
    void calculateContainsFourOperations(String input, String expected) {
        int expectedValue = Integer.parseInt(expected);

        final int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("입력 값이 null일 경우, IllegalArgumentException throw")
    void calculateThrowIllegalArgumentExceptionIfNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
    }

    @Test
    @DisplayName("입력 값이 빈 공백 문자일 경우, IllegalArgumentException throw")
    void calculateThrowIllegalArgumentExceptionIfEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(" ");
        });
    }

    @Test
    @DisplayName("입력 값에 연산 기호가 아닌 값이 포함될 경우, IllegalArgumentException throw")
    void calculateThrowIllegalArgumentExceptionIfContainsNotOperationSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("4 + 4 ^ 2");
        });
    }

}
