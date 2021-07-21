package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @ParameterizedTest(name = "덧셈 연산이 가능하다.")
    @CsvSource(value = {"1 + 2, 3", "4 + 5, 9", "100 + 200, 300"})
    public void additionTest(String input, int result) {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

}