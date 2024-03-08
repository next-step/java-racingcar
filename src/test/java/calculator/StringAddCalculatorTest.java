package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    class SingleNumberStringCase {

        @Test
        @DisplayName("문자열 '1'를 입력하면 숫자 1를 반환")
        void returnInt1WhenInputStr1() {
            int actual = StringAddCalculator.sum("1");
            assertThat(actual).isEqualTo(1);
        }

        @Test
        @DisplayName("문자열 '9'를 입력하면 숫자 9를 반환")
        void returnInt9WhenInputStr9() {
            int actual = StringAddCalculator.sum("9");
            assertThat(actual).isEqualTo(9);
        }

    }

}
