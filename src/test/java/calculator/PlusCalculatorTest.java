package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlusCalculatorTest {

    private PlusCalculator plusCalculator;

    @BeforeEach
    public void setUp() {
        plusCalculator = new PlusCalculator();
    }

    @DisplayName("덧셈 계산이 정상적으로 되는 지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "100:300", "1.5:2.5"}, delimiter = ':')
    public void plusCalculateTest(float operand1, float operand2) {
        float operatedValue = plusCalculator.calculate(operand1, operand2);

        Assertions.assertThat(operatedValue).isEqualTo(operand1 + operand2);
    }
}