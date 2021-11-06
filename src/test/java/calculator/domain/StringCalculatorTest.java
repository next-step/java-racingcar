package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

    @DisplayName("계산을 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 / 5,1", "1 - 4 + 6,3", "2 * 6,12"})
    void calculate(String expression, double expect) {
        // given
        StringCalculator calculator = StringCalculator.getInstance();

        // when
        Operand result = calculator.execute(expression);

        // then
        Assertions.assertThat(result).isEqualTo(Operand.of(expect));
    }
}
