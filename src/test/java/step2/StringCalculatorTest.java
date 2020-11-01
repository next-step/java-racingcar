package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void checkPlusTest() {
        assertThat(calculator.plus(4, 3)).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void checkMinusTest() {
        assertThat(calculator.minus(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void checkMultipleTest() {
        assertThat(calculator.multiple(4, 3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 테스트 - 정상")
    void checkDivideTest() {
        assertThat(calculator.divide(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("나눗셈 테스트 - 0으로 나누면 에러")
    void checkDivideZeroErrorTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(4, 0));
    }

    @Test
    @DisplayName("입력값 null 테스트")
    void checkInputNullTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(null));
    }

    @Test
    @DisplayName("입력값이 없는 테스트")
    void checkEmptyInputTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(""));
    }

    @Test
    @DisplayName("입력값이 빈 공백 테스트")
    void checkOnlyWhitespaceInputTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(" "));
    }

    @Test
    @DisplayName("입력값 중 숫자가 아닌 경우 예외처리 테스트")
    void checkNumberInputTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("d + 5"));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 테스트")
    void checkOperatorInputTest() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("3 ^ 7"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("사칙연산 테스트")
    void checkCalculateTest(String data) {
        assertThat(calculator.calculate(data)).isEqualTo(10);
    }

}