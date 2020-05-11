package me.daeho.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {
    private StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("덧셈 테스트")
    public void addTest() {
        int result = calculator.add(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtractTest() {
        int result = calculator.subtract(2, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    public void multiplyTest() {
        int result = calculator.multiply(3, 2);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    public void divideTest() {
        int result = calculator.divide(6, 3);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("빈 문자열 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void emptyStringTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            calculator.calculate(input)
        );
    }

    @DisplayName("사칙 연산 기호가 아닌경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 % 2", "5 @ 1"})
    public void nonFourArithmeticOperationTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.calculate(input)
        );
    }

    @DisplayName("정상 케이스 테스트")
    @Test
    public void normalCaseTest() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}