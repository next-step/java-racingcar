package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {


    @DisplayName("문자열 계산기 연산 테스트 - input의 결과가 expected과 일치해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6", "1 - 2 + 3:2", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String input, String expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(Integer.parseInt(expected));
    }
}