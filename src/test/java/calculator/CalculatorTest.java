package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("콜론 구분자 더하기")
    public void sumWithColonDelimiter() {
        assertThat(calculator.sum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마 구분자 더하기")
    public void sumWithCommaDelimiter() {
        assertThat(calculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콤마와 콜론 혼합 더하기")
    public void sumWithCommaAndColonDelimiter() {
        assertThat(calculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자 더하기")
    public void sumWithEmptyString() {
        assertThat(calculator.sum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("공백 문자 더하기")
    public void sumWithBlankString() {
        assertThat(calculator.sum(" ")).isEqualTo(0);
    }

    @Test
    @DisplayName("null 더하기")
    public void sumWithNull() {
        assertThat(calculator.sum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("커스텀 구분자로 더하기")
    public void sumWithCustomDelimiter() {
        assertThat(calculator.sum("////\n1//2")).isEqualTo(3);
    }

}
