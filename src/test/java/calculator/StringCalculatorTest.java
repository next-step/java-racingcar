package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("정상적인 입력으로 계산이 되는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6" , "1 + 2 / 3:1", "3 - 4:-1"}, delimiter = ':')
    void calculate(String formula, float calculatedValue) {
        Float result = stringCalculator.calculate(formula);

        Assertions.assertThat(result).isEqualTo(calculatedValue);
    }
}