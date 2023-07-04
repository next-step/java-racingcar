package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void emptyOrNullReturnZeroTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThat(calculator.calculate("")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void oneNumberStringReturnNumberTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThat(calculator.calculate("1")).isEqualTo(1);
        assertThat(calculator.calculate("2")).isEqualTo(2);
        assertThat(calculator.calculate("14")).isEqualTo(14);
    }

    @Test
    void commaSplitTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
        assertThat(calculator.calculate("4,5")).isEqualTo(9);

    }
}