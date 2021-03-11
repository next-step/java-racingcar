package calculator;

import calculator.common.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();
    private final char DELIMITER = ':';

    private int calculation(String data) {
        return stringCalculator.calculator(data);
    }

    @DisplayName("문자열 계산기 - 덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 + 10:20", "15 + 25:40", "31 + 32:63"}, delimiter = DELIMITER)
    public void additionTest(String data, int result) {
        assertThat(calculation(data)).isEqualTo(result);
    }

    @DisplayName("문자열 계산기 - 뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"50 - 2:48", "5 - 1:4", "1 - 1:0"}, delimiter = DELIMITER)
    public void subtractionTest(String data, int result) {
        assertThat(calculation(data)).isEqualTo(result);
    }

    @DisplayName("문자열 계산기 - 곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"11 * 11:121", "8 * 9:72", "100 * 100:10000"}, delimiter = DELIMITER)
    public void multiplicationTest(String data, int result) {
        assertThat(calculation(data)).isEqualTo(result);
    }

    @DisplayName("문자열 계산기 - 나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"33 / 11:3", "36 / 3:12", "7 / 1:7"}, delimiter = DELIMITER)
    public void divisionTest(String data, int result) {
        assertThat(calculation(data)).isEqualTo(result);
    }
}