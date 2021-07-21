package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    public void addTest() {
        //given
        StringCalculator.answer = 0;
        //when, then
        assertThat(StringCalculator.add("5")).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtractTest() {
        //given
        StringCalculator.answer = 2;
        //when, then
        assertThat(StringCalculator.subtract("2")).isEqualTo(0);
    }

    @Test
    @DisplayName("곱셈 테스트")
    public void multiplyTest() {
        //given
        StringCalculator.answer = 2;
        //when, then
        assertThat(StringCalculator.multiply("3")).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    public void divideTest() {
        //given
        StringCalculator.answer = 2;
        //when, then
        assertThat(StringCalculator.divide("1")).isEqualTo(2);
    }

    @Test
    @DisplayName("연산 테스트")
    public void calculateTest() {
        //given
        String input = "5 + 4 * 3 / 9";
        //when, then
        assertThat(StringCalculator.calculate(input)).isEqualTo(3);
    }

    @Test
    @DisplayName("input 예외테스트")
    public void inputExceptionTest() {
        //given
        String input = null;
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

    @Test
    @DisplayName("사칙연산 예외테스트")
    public void operatorExceptionTest() {
        //given
        String input = "5 + 4 * 3 ! 9";
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }
}