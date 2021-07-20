package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;
    private Validation validation;

    @BeforeEach
    void init() {
        calculator = new Calculator();
        validation = new Validation();
    }

    @Test
    @DisplayName("덧셈")
    void plusTest() {
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void minusTest() {
        int result = calculator.minus(10, 1);
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("곱셈")
    void multipleTest() {
        int result = calculator.multiplication(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    void devisionTest() {
        int result = calculator.devision(6, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("사칙연산 성공")
    void calculateTest() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 값이 Null")
    void inputNull() {
        assertThatThrownBy(() -> calculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 NULL입니다.");
    }

    @Test
    @DisplayName("입력 값에 빈 값이 존재")
    void inputBlank() {
        assertThatThrownBy(() -> calculator.calculate("1  + 2 - 3 * 4 / 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값에 빈값 또는 NULL이 포함돼있습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    void inputOperator() {
        assertThatThrownBy(() -> calculator.calculate("1 & 2 - 3 * 4 / 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
