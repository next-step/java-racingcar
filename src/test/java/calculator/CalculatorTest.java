package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈 성공 테스트")
    void plusTest() {
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 성공 테스트")
    void minusTest() {
        int result = calculator.minus(10, 1);
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("곱셈 성공 테스트")
    void multipleTest() {
        int result = calculator.multiplication(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 성공 테스트")
    void devisionSuccessTest() {
        int result = calculator.devision(6, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 실패(0으로 나눴을때) 테스트")
    void devisionFailTest() {
        assertThatThrownBy(() -> calculator.devision(3, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로는 연산이 불가합니다.");
    }

    @Test
    @DisplayName("사칙연산 성공 테스트")
    void calculateTest() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 값이 null일 때 발생하는 오류 테스트")
    void inputNull() {
        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 NULL입니다.");
    }

    @Test
    @DisplayName("입력 값에 빈 값이 존재할 때 발생하는 오류 테스트")
    void inputBlank() {
        assertThatThrownBy(() -> calculator.calculate("1  + 2 - 3 * 4 / 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값에 빈값 또는 NULL이 포함돼있습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우에 발생하는 오류 테스트")
    void inputOperator() {
        assertThatThrownBy(() -> calculator.calculate("1 & 2 - 3 * 4 / 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }

    @Test
    @DisplayName("연산자->피연산자 순서로 입력했을때 발생하는 오류 테스트")
    void userInputInvalid() {
        assertThatThrownBy(() -> calculator.calculate("+ 1 + 2 - 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }

}
