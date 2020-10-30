package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @ParameterizedTest
    @CsvSource(value = {
            "3 + 5 / 2 * 5 + 10 - 5 = 25"
    }, delimiter = '=')
    public void calculate(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    /*
    - CsvSource 의 기본 delimeter?
     */
    @DisplayName("단일 계산 사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = "10, 2")
    public void 단항연산자_테스트(int first, int second) {
        assertThat(Operator.PLUS.calculate(first, second)).isEqualTo(first + second);
        assertThat(Operator.MINUS.calculate(first, second)).isEqualTo(first - second);
        assertThat(Operator.MULTIPLE.calculate(first, second)).isEqualTo(first * second);
        assertThat(Operator.DIVIDE.calculate(first, second)).isEqualTo(first / second);
    }

}
