package calculator;

import calculator.common.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("문자열 계산기 - 덧셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = "11 + 3")
    public void additionTest(String data) {
        int result = stringCalculator.calculator(data);
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("문자열 계산기 - 뺄셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = "50 - 2")
    public void subtractionTest(String data) {
        int result = stringCalculator.calculator(data);
        assertThat(result).isEqualTo(48);
    }

    @DisplayName("문자열 계산기 - 곱셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = "11 * 11")
    public void multiplicationTest(String data) {
        int result = stringCalculator.calculator(data);
        assertThat(result).isEqualTo(121);

    }

    @DisplayName("문자열 계산기 - 나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = "600 / 12")
    public void divisionTest(String data) {
        int result = stringCalculator.calculator(data);
        assertThat(result).isEqualTo(50);

    }
}