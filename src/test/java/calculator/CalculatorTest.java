package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = input -> Double.valueOf(input);
    }

    @Test
    @DisplayName("계산 시 입력 값은 double 형으로 변환하여 반환한다.")
    void emptyCalculateTest(){
        String input = "2";
        Double expected = 2d;

        double result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {"2:0"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("0으로 나누면 ArithmeticException 예외를 던진다.")
    void divisionWithZeroTest(double a, double b) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.divide(a, b));
    }
}
