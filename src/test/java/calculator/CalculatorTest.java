package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @Test
    @DisplayName("문자열 앞부분에 // 와 \n 사이의 문자를 커스텀 구분자로 사용한다.")
    void custom_regex_sum() {
        // given
        Calculator calculator = new Calculator();
        String given = "//&\n1&3";

        // when
        long sum = calculator.calculate(given);

        // then
        assertThat(sum).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이나 null이 주어지면 0을 반환한다.")
    @NullAndEmptySource
    void return_zero(String given) {
        // given
        Calculator calculator = new Calculator();

        // when
        long sum = calculator.calculate(given);

        // then
        assertThat(sum).isEqualTo(0);
    }
}
