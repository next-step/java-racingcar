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
        int result2 = calculator.subtract(13, 21);
        int result3 = calculator.subtract(400, 201);

        // then
        assertThat(result).isEqualTo(2);
        assertThat(result2).isEqualTo(-8);
        assertThat(result3).isEqualTo(199);
    }

    @Test
    @DisplayName("곱셈 구현 확인")
    void multiply() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.multiply(3, 4);
        int result2 = calculator.multiply(10, 14);
        int result3 = calculator.multiply(201, 123);

        // then
        assertThat(result).isEqualTo(12);
        assertThat(result2).isEqualTo(140);
        assertThat(result3).isEqualTo(24723);

    }

    @Test
    @DisplayName("나눗셈 구현 확인")
    void divide() throws Exception {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.divide(12, 2);
        int result2 = calculator.divide(180, 20);
        int result3 = calculator.divide(150, 23);

        // then
        assertThat(result).isEqualTo(6);
        assertThat(result2).isEqualTo(9);
        assertThat(result3).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값이 null일 때 예외처리 확인")
    void checkNull() {

    }

    @Test
    @DisplayName("입력값이 빈 문자열일 때 예외처리 확인")
    void checkEmptyString() {

    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 확인")
    void checkOperator() {

    }

    @Test
    @DisplayName("사친 연산 모두 확인")
    void calculate() throws Exception {

    }
}