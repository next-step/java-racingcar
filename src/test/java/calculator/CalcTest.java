package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @ParameterizedTest
    @CsvSource(value = {"2,1"})
    @DisplayName("사칙연산 테스트")
    void calc(int a, int b) {
        assertThat(Calculator.execute("+", a, b)).isEqualTo(3);
        assertThat(Calculator.execute("-", a, b)).isEqualTo(3);
        assertThat(Calculator.execute("*", a, b)).isEqualTo(3);
        assertThat(Calculator.execute("/", a, b)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 + 2 * 3 / 2:9"}, delimiter = ':')
    @DisplayName("문자열 계산기 테스트")
    void stringCalculatorTest(String inputStr, int result) {
        StringCalculator stringCalculator = new StringCalculator(inputStr);
        assertThat(stringCalculator.execute()).isEqualTo(result);
    }


}
