package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환")
    void return0WhenEmptyString() {
        int actual = StringAddCalculator.sum("");
        assertThat(actual).isZero();
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환")
    void return0WhenNull() {
        int actual = StringAddCalculator.sum(null);
        assertThat(actual).isZero();
    }
}
