package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        assertThat(StringCalculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract() {
        assertThat(StringCalculator.subtract(2, 3)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiple() {
        assertThat(StringCalculator.multiple(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        assertThat(StringCalculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 결과 infinity 값이 나올 경우의 예외처리 테스트")
    void divideException() {

    }
}
