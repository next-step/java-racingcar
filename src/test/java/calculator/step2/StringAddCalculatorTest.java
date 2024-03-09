package calculator.step2;

import calculator.step2.StringAddCalculator;
import org.junit.jupiter.api.Test;

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

    @Test
    void colonAndCommaTest() {
        int number = stringAddCalculator.calculate("1:2,3");
        assertThat(number).isEqualTo(6);
    }

    @Test
    void colonTest() {
        int number = stringAddCalculator.calculate("1:2");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void commaTest() {
        int number = stringAddCalculator.calculate("1,2");
        assertThat(number).isEqualTo(3);
    }

    @Test
    void commaEndTest() {
        int number = stringAddCalculator.calculate("1,");
        assertThat(number).isEqualTo(1);
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
