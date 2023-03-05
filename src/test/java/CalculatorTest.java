import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private double a;
    private double b;

    @BeforeEach
    void setUp() {
        a = 3;
        b = 2;
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2 = 10"
            , "2.1 / 1 * 50 + 2 = 107"
            , "3 * 3 / 40 - 5 = -4.775"}
            , delimiter = '=')
    void calculate(String expression, Double answer) {
        assertThat(Calculator.calculate(expression)).isEqualTo(answer);
    }

    @Test
    void classifyExpression() {
        Calculator.ElementLists elementLists = Calculator.classifyExpression("2 + 3 * 4 / 2");
        assertThat(elementLists.digitList).isEqualTo(Arrays.asList(2.0, 3.0, 4.0, 2.0));
        assertThat(elementLists.opList).isEqualTo(Arrays.asList('+', '*', '/'));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.classifyExpression("3 ^ 2"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.classifyExpression(""));
    }

    @Test
    void isNumeric() {
        assertThat(Calculator.isNumeric("1")).isTrue();
        assertThat(Calculator.isNumeric("100")).isTrue();
        assertThat(Calculator.isNumeric("2.1")).isTrue();
        assertThat(Calculator.isNumeric("+")).isFalse();
        assertThat(Calculator.isNumeric("3+")).isFalse();
    }

    @Test
    void isBasicOp() {
        assertThat(Calculator.isBasicOp("+")).isTrue();
        assertThat(Calculator.isBasicOp("-")).isTrue();
        assertThat(Calculator.isBasicOp("*")).isTrue();
        assertThat(Calculator.isBasicOp("/")).isTrue();
        assertThat(Calculator.isBasicOp("+/")).isFalse();
        assertThat(Calculator.isBasicOp("2")).isFalse();
        assertThat(Calculator.isBasicOp("^")).isFalse();
    }

    @Test
    void compute() {
        assertThat(Calculator.compute('+', a, b)).isEqualTo(5);
        assertThat(Calculator.compute('-', a, b)).isEqualTo(1);
        assertThat(Calculator.compute('*', a, b)).isEqualTo(6);
        assertThat(Calculator.compute('/', a, b)).isEqualTo(1.5);
    }

    @Test
    void add() {
        assertThat(Calculator.add(a, b)).isEqualTo(5);
    }

    @Test
    void subtract() {
        assertThat(Calculator.subtract(a, b)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(Calculator.multiply(a, b)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(Calculator.divide(a, b)).isEqualTo(1.5);
    }
}