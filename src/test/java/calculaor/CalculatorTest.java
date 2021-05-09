package calculaor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    private int number1;
    private int number2;


    @BeforeEach
    void Setup() {
        number1 = 4;
        number2 = 2;
    }

    // 사칙연산 테스트
    @Test
    void addTest() {
        // given
        Calculator calculator = new Calculator();

        // when
        int expected = 6;
        int actual = calculator.add(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subTest() {
        // given
        Calculator calculator = new Calculator();

        // when
        int expected = 2;
        int actual = calculator.sub(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void mulTest() {
        // given
        Calculator calculator = new Calculator();

        // when
        int expected = 8;
        int actual = calculator.mul(number1, number2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    // (4,2 : true), (4,0 : 예외처리), (4,5 : false)
    void divTest() {
        assertThatThrownBy(() -> {
            // given
            int exceptnum1 = 4;
            int exceptnum2 = 0;
            int testnum1 = 4;
            int testnum2 = 3;
            Calculator calculator = new Calculator();

            // when
            int expected = 2;
            int actual = calculator.div(number1, number2);
            int actual1 = calculator.div(testnum1, testnum2);
            int actual2 = calculator.div(exceptnum1, exceptnum2);

            // then
            assertThat(actual).isEqualTo(expected);
            assertThat(actual1).isEqualTo(expected);
            assertThat(actual2).isEqualTo(expected);
        }).isInstanceOf(ArithmeticException.class);
    }
}
