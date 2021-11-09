import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void testPlus() {
        MyNumber result = Calculator.calc("2 + 3");
        assertThat(result).isEqualTo(new MyNumber(5));
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testMinus() {
        MyNumber result = Calculator.calc("3 - 1");
        assertThat(result).isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiply() {
        MyNumber result = Calculator.calc("3 * 2");
        assertThat(result).isEqualTo(new MyNumber(6));
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivide() {
        MyNumber result = Calculator.calc("6 / 3");
        assertThat(result).isEqualTo(new MyNumber(2));
    }

    @Test
    @DisplayName("여러개의 연산자를 테스트")
    void testCalculate() {
        MyNumber result3 = Calculator.calc("2 + 3 * 4 / 2");
        assertThat(result3).isEqualTo(new MyNumber(10));
    }

    @Test
    @DisplayName("예외 케이스 테스트. 입력값이 빈 값이거나 지원하지 않는 연산자를 테스트")
    void testException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calc(null))
                .withMessage("문자열이 비었습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calc(""))
                .withMessage("문자열이 비었습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.calc("10 % 3"))
                .withMessage("지원하지 않는 연산자 입니다.");
    }
}
