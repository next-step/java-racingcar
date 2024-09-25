package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("콜론 구분자 더하기")
    public void sumWithColonDelimiter() {
        Calculator calculator = new Calculator();
        assertThat(calculator.sum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마 구분자 더하기")
    public void sumWithCommaDelimiter() {
        Calculator calculator = new Calculator();
        assertThat(calculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마와 콜론 혼합 더하기")
    public void sumWithCommaAndColonDelimiter() {
        Calculator calculator = new Calculator();
        assertThat(calculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자 더하기")
    public void sumWithEmptyString() {
        Calculator calculator = new Calculator();
        assertThat(calculator.sum("")).isEqualTo(0);
    }
}
