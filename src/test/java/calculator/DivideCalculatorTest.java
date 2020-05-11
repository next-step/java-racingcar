package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DivideCalculatorTest {

    private DivideCalculator divideCalculator;

    @BeforeEach
    public void setUp() {
        divideCalculator = new DivideCalculator();
    }

    @DisplayName("나눗셈 계산이 정상적으로 되는 지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:5", "25.5:5", "5:1", "2:2", "12354:545"}, delimiter = ':')
    public void divideCalculateTest(float dividend, float divisor) {
        float calculatedValue = divideCalculator.calculate(dividend, divisor);

        assertThat(calculatedValue).isEqualTo(dividend / divisor);
    }
}