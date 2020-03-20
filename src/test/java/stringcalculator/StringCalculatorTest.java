package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("주어진 문자열에서 숫자들의 덧셈 결과를 리턴한다")
    public void addOperationReturnsSumOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.add("1 + 2")).isEqualTo(3);
    }
}
