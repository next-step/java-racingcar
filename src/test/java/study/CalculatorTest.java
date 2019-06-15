package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add() {
        String sample = "2 + 3";

        assertThat(calc.calculate(sample)).isEqualTo(5);
    }

    @Test
    void subtract() {
        String sample = "2 - 3";

        assertThat(calc.calculate(sample)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        String sample = "2 * 3";

        assertThat(calc.calculate(sample)).isEqualTo(6);
    }

    @Test
    void divide() {
        String sample = "6 / 3";

        assertThat(calc.calculate(sample)).isEqualTo(2);
    }

    @Test
    void multi_operator() {
        String sample = "2 + 3 * 4 / 2 - 4";

        assertThat(calc.calculate(sample)).isEqualTo(6);
    }

    @Test
    void 잛못된입력_빈값_입력시() {
        String sample = "";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculate(sample));
    }

    @Test
    void 잘못된입력_null_입력시() {
        String sample = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculate(sample));
    }

    @Test
    void 잘못된입력_사칙연산이아닌문자_입력시() {
        String sample = "1 & 1";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculate(sample));
    }
}