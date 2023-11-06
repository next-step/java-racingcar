package calculator;

import calculator.exception.NegativeNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextCalculatorTest {

    @Test
    @DisplayName("덧셈기능/null을 넣으면/0이 나온다.")
    void calculateNull() {
        assertThat(TextCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("덧셈기능/빈문자열을 넣으면/0이 나온다.")
    void calculate_빈_문자열() {
        assertThat(TextCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("덧셈기능/숫자한개를 넣으면/그 숫자가 나온다.")
    void calculate_숫자_한개() {
        assertThat(TextCalculator.calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("덧셈기능/기본구분자로 숫자를분리하고/계산한다.")
    void calculate_기본_구분자() {
        assertThat(TextCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(TextCalculator.calculate("1,2,3")).isEqualTo(6);
        assertThat(TextCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈기능/커스텀구분자로 숫자를분리하고/계산한다.")
    void calculate_커스텀_구분자() {
        assertThat(TextCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈기능/분리후 숫자이외의 값이있다면/NotNumberException")
    void calculate_기본_구분자_숫자이외의_값() {
        Assertions.assertThatThrownBy(
                () -> TextCalculator.calculate("1,2,a")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("덧셈기능/분리후 숫자가 음수라면/NegativeNumberException")
    void calculate_기본_구분자_음수값() {
        Assertions.assertThatThrownBy(
                () -> TextCalculator.calculate("1,2,-1")).isInstanceOf(NegativeNumberException.class);
    }
}
