package calculator.step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.step2.StringAddCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    void negativeTest() {
        assertThatThrownBy(() ->
                calculate("-1,3,2")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void customTest() {
        int number = calculate("//;\n1;2;3");
        assertThat(number).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2=3", "1:2,3=6", "1:2,3:9=15"}, delimiter = '=')
    void colonAndCommaTest(String input, int expected) {
        int number = calculate(input);
        assertThat(number).isEqualTo(expected);
    }

    @Test
    void oneNumberTest2() {
        int number = calculate("111");
        assertThat(number).isEqualTo(111);
    }

    @Test
    void oneNumberTest() {
        int number = calculate("1");
        assertThat(number).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void isNullAndBlankTest(String input) {
        int number = calculate(input);
        assertThat(number).isEqualTo(0);
    }

}
