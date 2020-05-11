package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MinusCalculatorTest {
    private MinusCalculator minusCalculator;

    @BeforeEach
    public void setUp() {
        minusCalculator = new MinusCalculator();
    }


    @DisplayName("뺄셈 계산이 정상적으로 되는 지 확인")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "1:3", "35.32:23.23"}, delimiter = ':')
    public void minusCalculatorTest(float operand1, float operand2) {
        float calculatedValue = minusCalculator.calculate(operand1, operand2);

        Assertions.assertThat(calculatedValue).isEqualTo(operand1 - operand2);
    }
}