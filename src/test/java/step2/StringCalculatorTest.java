package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("덧셈 테스트")
    void plus() {
        String result = stringCalculator.plus(2, 3);

        assertThat(result).isEqualTo("5");
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus() {
        String result = stringCalculator.minus(2, 3);

        assertThat(result).isEqualTo("-1");
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        String result = stringCalculator.multiply(2, 3);

        assertThat(result).isEqualTo("6");
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void division() {
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void nullOrEmpty() {
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    void notSign() {
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 테스트")
    void testAll() {
    }
}
