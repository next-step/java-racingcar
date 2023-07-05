package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import caculator.Calculator;
import caculator.delimiter.DelimiterParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    DelimiterParser delimiterParser = new DelimiterParser();
    Calculator calculator = new Calculator(delimiterParser);

    @Test
    @DisplayName("쉼표를 구분자로 가지는 경우")
    void commaDelimiterTest() {
        assertThat(
                calculator.sum("1,2,3")
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론을 구분자로 가지는 경우")
    void colonDelimiterTest() {
        assertThat(
                calculator.sum("1:2:3")
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 경우")
    void basicDelimiterTest() {
        assertThat(
                calculator.sum("1,2:3")
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 가지는 경우")
    void customDelimiterTest() {
        assertThat(
                calculator.sum("//;\n1;2;3")
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("null, 빈 문자열, 공백을 사용하는 경우")
    void negativeIncludedTest2() {
        String[] texts = { null, "", "   "};
        for (String text : texts) {
            assertThat(
                    calculator.sum(text)
            ).isZero();
        }
    }

    @Test
    @DisplayName("음수를 사용하는 경우")
    void negativeIncludedTest1() {
        assertThatThrownBy(
                () -> calculator.sum("-1,2")
        ).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("구분자를 연속해서 사용하는 경우")
    void negativeDelimiterTest() {
        assertThatThrownBy(
                () -> calculator.sum("//-\n1--2-3")
        ).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값을 사용하는 경우")
    void wrongTextTest() {
        assertThatThrownBy(
                () -> calculator.sum("1,가,3")
        ).isExactlyInstanceOf(RuntimeException.class);
    }

}
