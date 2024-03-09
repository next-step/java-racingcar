package calculator.step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    void negativeTest() {
        assertThatThrownBy(() ->
                stringAddCalculator.calculate("-1,3,2")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void customTest() {
        int number = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(number).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1:2=3", "1:2,3=6", "1:2,3:9=15"}, delimiter = '=')
    void colonAndCommaTest(String input, int expected) {
        int number = stringAddCalculator.calculate(input);
        assertThat(number).isEqualTo(expected);
    }

    @Test
    void oneNumberTest2() {
        int number = stringAddCalculator.calculate("111");
        assertThat(number).isEqualTo(111);
    }

    @Test
    void oneNumberTest() {
        int number = stringAddCalculator.calculate("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    void blankTest() {
        int number = stringAddCalculator.calculate("");
        assertThat(number).isEqualTo(0);
    }

    @Test
    void nullTest() {
        int number = stringAddCalculator.calculate(null);
        assertThat(number).isEqualTo(0);
    }

}
