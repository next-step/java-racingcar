package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author : 김윤호
 * @version :
 * @date : 2019-10-25 19:34
 */
public class CalculatorTest {

    @Test
    void stringCalculatorTest() {
        double resultValue = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(resultValue).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5", "10,5"})
    void plusTest(double value1, double value2) {
        Calculator calculator = Calculator.PLUS;
        assertThat(calculator.calculate(value1, value2)).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,5", "5,10"})
    void minusTest(double value1, double value2) {
        Calculator calculator = Calculator.MINUS;
        assertThat(calculator.calculate(value1, value2)).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,5", "5,10"})
    void multiplyTest(double value1, double value2) {
        Calculator calculator = Calculator.MULTIPLY;
        assertThat(calculator.calculate(value1, value2)).isEqualTo(50);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,5", "10,2.5"})
    void divideTest(double value1, double value2) {
        Calculator calculator = Calculator.DIVIDE;
        assertThat(calculator.calculate(value1, value2)).isEqualTo(2);
    }

    @Test
    void nullStringTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           StringCalculator.calculate(null);
        });
    }

    @Test
    void emptyStringTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate("");
        });
    }

    @Test
    void operatorTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Calculator.findOperator("");
        }).withMessageMatching("Invalid Operator");
    }
}
