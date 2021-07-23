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

}
