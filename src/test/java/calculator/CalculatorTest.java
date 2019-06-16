package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @CsvSource({"123, 123"
            , "1 - 2, -1"
            , "1 + 2 + 3, 6"
            , "2 + 3 * 4 / 2, 10"
            , "1343 + 231 * 2 / 4, 787"
            , "25 + 30 - 12 * 20 / 5, 172"
            , "1 + 1 - 1 * 1 / 1, 1"
    })
    void 계산기능_테스트(String expression, int expectedResult) {
        assertThat(Calculator.calculate(expression)).isEqualTo(expectedResult);
    }
}