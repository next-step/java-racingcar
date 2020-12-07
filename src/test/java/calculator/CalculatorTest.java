package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "1 - 2,-1", "3 * 4,12", "12 / 2,6"})
    @DisplayName("연산자 1개 case 테스트")
    void one_operation_calculator_test(String input, Integer expected) {
        Integer output = Calculator.equality(input);
        assertThat(output).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1 + 2 + 3, 6", "1 - 2 + 1,0", "3 * 4 / 2,6", "12 / 2 - 4,2", "1 + 2 + 3 / 3, 2"})
    @DisplayName("연산자 2개 이상 case 테스트")
    void two_more_operation_calculator_test(String input, Integer expected) {
        Integer output = Calculator.equality(input);
        assertThat(output).isEqualTo(expected);
    }
}
