import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("덧셈 구현 확인")
    void add() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.add(1, 2);
        int result2 = calculator.add(10, 40);
        int result3 = calculator.add(130, 560);

        // then
        assertThat(result).isEqualTo(3);
        assertThat(result2).isEqualTo(50);
        assertThat(result3).isEqualTo(690);
    }

    @Test
    @DisplayName("뺄셈 구현 확인")
    void subtract() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.subtract(3, 1);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 구현 확인")
    void multiply() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.multiply(3, 4);

        // then
        assertThat(result).isEqualTo(12);

    }

    @Test
    @DisplayName("나눗셈 구현 확인")
    void divide() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.divide(12, 2);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값이 null일 때 예외처리 확인")
    void checkNull() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator(null);
                });

    }

    @Test
    @DisplayName("입력값이 빈 문자열일 때 예외처리 확인")
    void checkEmptyString() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator("");
                });

    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 확인")
    void checkOperator() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator("1 $ 2");
                    calculator.calculate();
                });

    }

    @Test
    @DisplayName("사친 연산 모두 확인")
    void calculate() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator("1 + 2 / 1 * 2 + 3 - 4");

        // when
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(5);
    }
}