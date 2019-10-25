package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void 덧셈() {

        //given
        String inputString = "2 + 3";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {

        //given
        String inputString = "5 - 2";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 곱셈() {

        //given
        String inputString = "3 * 4";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 나눗셈() {

        //given
        String inputString = "20 / 2";
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(inputString);

        //then
        assertThat(result).isEqualTo(10);
    }
}
