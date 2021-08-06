package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    @Test
    @DisplayName("덧셈")
    void addition() {
        assertEquals(10, Calculator.addition(5, 5));
    }

    @Test
    @DisplayName("뺄셈")
    void subtraction() {
        assertEquals(0, Calculator.subtraction(5, 5));
    }

    @Test
    @DisplayName("곱셈")
    void multiplication() {
        assertEquals(25, Calculator.multiplication(5, 5));
    }

    @Test
    @DisplayName("나눗셈")
    void division() {
        assertEquals(5, Calculator.division(25, 5));
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void blankAndNullCheck(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Calculator.isBlank(input));
    }

    @DisplayName("사칙 연산 기호가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"!", "&"})
    void calculation(char operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Calculator.calculate(2, operator, 5));
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 기능")
    void makeResultTest() {
        assertEquals(10, Calculator.makeResult("2 + 3 * 4 / 2"));
    }

}
