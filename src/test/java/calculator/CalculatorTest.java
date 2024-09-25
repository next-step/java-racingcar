package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator=new Calculator();

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
    @DisplayName("숫자가 아닌 문자 더하기")
    public void sumNonNumber() {
        assertThatThrownBy(()->calculator.sum("a,b:c"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageEndingWith("양수가 아닙니다.");
    }

    @Test
    @DisplayName("음수 더하기")
    public void sumNegative() {
        assertThatThrownBy(()->calculator.sum("-1,1:2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageEndingWith("양수가 아닙니다.");
    }
}
