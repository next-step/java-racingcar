package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void sum() {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.sum(3, 4);

        //then
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void subtract() {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.subtract(10, 6);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void multiply() {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.multiply(10, 10);

        //then
        assertThat(result).isEqualTo(100);
    }

    @Test
    public void divide() {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.divide(10, 2);

        //then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2", "10 + 10 * 5 / 10"})
    @DisplayName("사칙연산 계산")
    public void calculate(String input) {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.calculate(input);

        //then
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생해야한다.")
    public void is_blank_should_throw_IllegalArgumentException(String input) {
        Calculator c = new Calculator();

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> c.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 & 2 ^ 4","4 * 3 # 9"})
    @DisplayName("사칙연산 기호가 아닌 경우 예외가 발생해야한다.")
    public void is_correct_operations_should_throw_IllegalArgumentException(String input) {
        Calculator c = new Calculator();

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> c.calculate(input));
    }

}
