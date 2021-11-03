package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {"2 *  ,2", "2 + 3 * ,5","2 + 3 * 7 - ,35"})
    @DisplayName("들어온 input이 형식에 맞지 않을 때 옳은 부분까지만 계신되는지 테스트")
    void invalidFormatInputCalcTest(String input, int expected) {
        assertThat(calculator.calculation(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 5 / 2,5", "2 + 3 * 2,10","2 + 3 * 2 - 7,3"})
    @DisplayName("들어온 input이 정상적인 연산 문자열일 때 계산이 정확한지 테스트")
    void calculationTest(String input, int expected) {
        assertThat(calculator.calculation(input)).isEqualTo(expected);
    }
}