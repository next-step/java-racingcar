package calculator.stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringSeparator separator = new StringSeparator();

    @Test
    @DisplayName("합계 테스트")
    void sumTest() {
        StringCalculator calculator = StringCalculator.from(separator);

        int result = calculator.calculate("1,2,3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("인자가 하나일 때 합계 테스트")
    void sumOnlyOneTest() {
        StringCalculator calculator = StringCalculator.from(separator);

        int result = calculator.calculate("123");

        assertThat(result).isEqualTo(123);
    }
}