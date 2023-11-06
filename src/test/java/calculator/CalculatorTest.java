package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("쉼표를 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한 각 숫자의 합을 구함")
    void rest_sum() {
        // given
        Calculator calculator = new Calculator();
        String given = "1,3";

        // when
        long sum = calculator.calculate(given);

        // then
        assertThat(sum).isEqualTo(4);
    }

    @Test
    @DisplayName("콜론을 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한 각 숫자의 합을 구함")
    void column_sum() {
        // given
        Calculator calculator = new Calculator();
        String given = "1:3";

        // when
        long sum = calculator.calculate(given);

        // then
        assertThat(sum).isEqualTo(4);
    }
}
