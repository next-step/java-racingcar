package unittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperatorTest {

    @DisplayName("더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "3:1:4", "4:4:8", "4:2:6"}, delimiter = ':')
    public void addTest(int a, int b, int expected) {
        assertThat(ArithmeticOperator.ADD_OPERATOR.calculate(a, b)).isEqualTo(expected);
    }

    @DisplayName("빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "3:1:2", "4:4:0", "4:2:2"}, delimiter = ':')
    public void substractTest(int a, int b, int expected) {
        assertThat(ArithmeticOperator.SUBSTRACT_OPERATOR.calculate(a, b)).isEqualTo(expected);
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "3:1:3", "4:4:16", "4:2:8"}, delimiter = ':')
    public void multyflyTest(int a, int b, int expected) {
        assertThat(ArithmeticOperator.MULTIPLY_OPERATOR.calculate(a, b)).isEqualTo(expected);
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:0", "3:1:3", "4:4:1", "4:2:2"}, delimiter = ':')
    public void dividedTest(int a, int b, int expected) {
        assertThat(ArithmeticOperator.DIVIDE_OPERATOR.calculate(a, b)).isEqualTo(expected);
    }
}

