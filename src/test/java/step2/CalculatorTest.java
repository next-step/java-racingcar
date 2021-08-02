package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 계산기 테스트")
public class CalculatorTest {
    @Test
    @DisplayName("덧셈 계산")
    public void sum() {
        //when
        int result = Calculator.SUM.calculate(3, 4);

        //then
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈 계산")
    public void subtract() {
        //when
        int result = Calculator.SUBTRACT.calculate(10, 6);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("곱셈 계산")
    public void multiply() {
        //when
        int result = Calculator.MULTIPLY.calculate(10, 10);

        //then
        assertThat(result).isEqualTo(100);
    }

    @Test
    @DisplayName("나눗셈 계산")
    public void divide() {
        //when
        int result = Calculator.DIVIDE.calculate(10, 2);

        //then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "10 + 10 * 5 / 10"})
    @DisplayName("사칙연산 계산")
    public void calculate(String input) {
        //when
        int result = Calculator.multiCalculate(input);

        //then
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생해야한다.")
    public void is_blank_should_throw_IllegalArgumentException(String input) {
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> Calculator.multiCalculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 & 2 ^ 4","4 * 3 # 9"})
    @DisplayName("사칙연산 기호가 아닌 경우 예외가 발생해야한다.")
    public void is_correct_operations_should_throw_IllegalArgumentException(String input) {
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> Calculator.multiCalculate(input));
    }

}
