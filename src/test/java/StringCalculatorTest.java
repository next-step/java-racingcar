import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test @DisplayName("덧셈 구현 테스트")
    void add() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.add(1, 2);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test @DisplayName("뺄셈 구현 테스트")
    void subtract() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.subtract(3, 1);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test @DisplayName("곱셈 구현 테스트")
    void multiply() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.multiply(3, 4);

        // then
        assertThat(result).isEqualTo(12);

    }

    @Test @DisplayName("나눗셈 구현 테스트")
    void divide() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.divide(12, 2);

        // then
        assertThat(result).isEqualTo(6);
    }
}