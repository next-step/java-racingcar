package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyCalculatorTest {

    private MultiplyCalculator multiplyCalculator;

    @BeforeEach
    public void setUp() {
        multiplyCalculator = new MultiplyCalculator();
    }

    @DisplayName("곱셈 계산이 정상적으로 되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:4", "4.5:2"}, delimiter = ':')
    public void multiplyCalculateTest(float operand1, float operand2) {
        float calculatedValue = multiplyCalculator.calculate(operand1, operand2);

        assertThat(calculatedValue).isEqualTo(operand1 * operand2);
    }

}