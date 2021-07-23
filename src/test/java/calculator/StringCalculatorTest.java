package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("NonAsciiCharacters")
public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "7 + 8 + 5,20"})
    void 덧셈_기능_확인(String expression, int expected) {
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2,-1", "5 - 3,2", "10 - 1 - 4,5"})
    void 뺄셈_기능_확인(String expression, int expected) {
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2,2", "5 * 3,15", "10 * 2 * 3,60"})
    void 곱셈_기능_확인(String expression, int expected) {
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expected);
    }

}
