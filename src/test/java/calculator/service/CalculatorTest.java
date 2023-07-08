package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    public static final Calculator CALCULATOR = Calculator.getInstance();

    @Test
    @DisplayName("쉼표를 구분자로 가지는 경우")
    void commaDelimiterTest() {
        assertThat(CALCULATOR.sum("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론을 구분자로 가지는 경우")
    void colonDelimiterTest() {
        assertThat(CALCULATOR.sum("1:2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 경우")
    void basicDelimiterTest() {
        assertThat(CALCULATOR.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 가지는 경우")
    void customDelimiterTest() {
        assertThat(CALCULATOR.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { "", "   " })
    @DisplayName("null, 빈 문자열, 공백을 사용하는 경우")
    void negativeIncludedTest2(final String text) {
        assertThat(CALCULATOR.sum(text)).isZero();
    }

    @Test
    @DisplayName("음수를 사용하는 경우")
    void negativeIncludedTest1() {
        assertThatThrownBy(() -> CALCULATOR.sum("-1,2")).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자를 연속해서 사용하는 경우")
    void negativeDelimiterTest() {
        assertThat(CALCULATOR.sum("//-\n1--2-3")).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값을 사용하는 경우")
    void wrongTextTest() {
        assertThatThrownBy(() -> CALCULATOR.sum("1,가,3")).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
