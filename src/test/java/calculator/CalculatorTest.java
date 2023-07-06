package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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

    @Test
    void colonSplitTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
        assertThat(calculator.calculate("1:2:3")).isEqualTo(6);
    }

    @Test
    void customSplitterTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(calculator.calculate("//;\n1,2;3")).isEqualTo(6);

    }

    @Test
    void notNumberThrowsRuntimeExceptionTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            calculator.calculate("a,2,3");
        });
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            calculator.calculate(" ");
        });
    }

    @Test
    void NegativeThrowsRuntimeExceptionTest() {
        //given
        Calculator calculator = new Calculator();

        //when, then
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            calculator.calculate("-1,2,3");
        });
    }
}