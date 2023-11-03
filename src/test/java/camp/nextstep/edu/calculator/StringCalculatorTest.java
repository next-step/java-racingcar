package camp.nextstep.edu.calculator;

import static camp.nextstep.edu.calculator.StringCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("null 또는 빈 문자열이 입력되면 0을 반환한다")
    void nullOrEmpty() {
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
        assertThat(calculate(" ")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 들어오면 그 숫자를 int 형태로 그대로 반환한다")
    void soleNumber() {
        assertThat(calculate("1")).isEqualTo(1);
        assertThat(calculate("999")).isEqualTo(999);
    }

    @Test
    @DisplayName("컴마로 구분된 여러 숫자들을 더해서 반환한다")
    void multipleNumbersWithComma() {
        assertThat(calculate("1,2")).isEqualTo(3);
        assertThat(calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("컴마 또는 콜론으로 구분된 여러 숫자들을 더해서 반환한다")
    void multipleNumbersWithCommaOrSemicolon() {
        assertThat(calculate("1:2")).isEqualTo(3);
        assertThat(calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 여러 숫자들을 더해서 반환한다")
    void multipleNumbersWithCustomDelimiter() {
        assertThat(calculate("\\;\n1;2")).isEqualTo(3);
        assertThat(calculate("\\!\n1!2!3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 또는 숫자 이외의 값이 들어오면 RuntimeException을 던진다")
    void negativeNumberOrNotNumber() {
        assertThatThrownBy(() -> calculate("-1"))
            .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> calculate("0,-1"))
            .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> calculate("HELLO"))
            .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> calculate("0,HELLO"))
            .isInstanceOf(RuntimeException.class);
    }
}
