package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {


    public static Calculator calculator = new Calculator();




    @Test
    void plusTest () {
        int result = 10;
        assertEquals(calculator.plus(1, 10),result + 1);
    }

    @Test
    void minusTest () {
        int result = 10;
        assertEquals(calculator.minus(1, 10),result - 1);
    }

    @Test
    void mutiplyTest () {
        int result = 10;
        assertEquals(calculator.multiply(2, 10),result * 2);
    }

    @Test
    void divideTest () {
        int result = 10;
        assertEquals(calculator.divide(2, 10),result / 2);
    }

    @Test
    void splitTest () {
        String[] result = "2 + 3 * 4 / 2".split(" ");
        assertThat(result).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void calculatorTest () {
        String[] result = "2 + 3 * 4 / 2".split(" ");
        int cal = calculator.calculator(result);
        assertEquals(cal,10);
    }

    @Test
    void calculatorTest_문자공백에러 () {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.splitString("");
                }).withMessageMatching("input 값이 NULL 또는 빈값입니다.");

    }

    @Test
    void calculatorTest_문자__null () {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.splitString(null);
                }).withMessageMatching("input 값이 NULL 또는 빈값입니다.");

    }

    @Test
    void calculatorTest_사칙연산아님 () {
        String[] result = "3 f 4".split(" ");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculator(result);
                }).withMessageMatching("input값이 사칙연산 기호가 아닙니다.");

    }

}
