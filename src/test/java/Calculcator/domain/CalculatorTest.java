package Calculcator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("입력 받은 수식의 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({"2 + 3 * 4 / 2, 10", "1 + 2 - 3, 0"})
    void calculation(String expression, int expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.calculation(expression);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
