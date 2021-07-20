package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 - 3 - 4 - 2:-7", "1 * 1 * 1 * 1:1", "1 + 1 - 1 - 1:0"}, delimiter = ':')
    @ParameterizedTest(name = "{0}의 결과값으로 {1}가 반환되어야한다")
    void calcTest(String given, int result) {
        assertThat(Calculator.calc(given)).isEqualTo(result);
    }

}