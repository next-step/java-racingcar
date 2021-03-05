package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @ParameterizedTest(name = "{0} {1} {2} 의 결과값은 {3}을 반환한다.")
    @CsvSource(value = {"10:+:15:25", "31:-:15:16", "11:*:16:176", "9:/:2:4", "8:/:2:4"}, delimiter = ':')
    public void calculate_ShouldReturnSumValueByAddSubtractMultiplyDivide(int number1, String operator, int number2, int expectedValue) {
        Calculator calculator = new Calculator(number1);

        assertThat(calculator.calculate(operator, number2)).isEqualTo(expectedValue);
    }

}
