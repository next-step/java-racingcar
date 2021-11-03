package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("들어온 input이 형식에 맞지 않을 때 옳은 부분까지만 계신되는지 테스트")
    void invalidFormatInputCalcTest() {
        assertThat(calculator.calculation("2 *  ")).isEqualTo(2);
        assertThat(calculator.calculation("2 + 3 * ")).isEqualTo(5);
        assertThat(calculator.calculation("2 + 3 * 7 - ")).isEqualTo(35);
    }

    @Test
    @DisplayName("들어온 input이 정상적인 연산 문자열일 때 계산이 정확한지 테스트")
    void calculationTest() {
        assertThat(calculator.calculation("2 * 5 / 2")).isEqualTo(5);
        assertThat(calculator.calculation("2 + 3 * 2")).isEqualTo(10);
        assertThat(calculator.calculation("2 + 3 * 2 - 7")).isEqualTo(3);
    }
}