package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    StringAddCalculator calculator = new StringAddCalculator();

    @Test
    void negativeTest() {
        assertThatThrownBy(() -> {
            calculator.calculate("-1,3,2");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("text(%s)는 음수입니다.", "-1"));
    }

    @Test
    void customTest() {
        int number = calculator.calculate("//;\n1;2;3");
        assertThat(number).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2=3", "1:2,3=6", "1:2,3:9=15"}, delimiter = '=')
    void colonAndCommaTest(String input, int expected) {
        int number = calculator.calculate(input);
        assertThat(number).isEqualTo(expected);
    }

    @Test
    void oneNumberTest2() {
        int number = calculator.calculate("111");
        assertThat(number).isEqualTo(111);
    }

    @Test
    void oneNumberTest() {
        int number = calculator.calculate("1");
        assertThat(number).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void isNullAndBlankTest(String input) {
        int number = calculator.calculate(input);
        assertThat(number).isEqualTo(0);
    }

}
