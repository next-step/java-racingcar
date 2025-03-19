package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.Calculator.add;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void getNumberFromString() {
        assertThat(add("1")).isEqualTo(1);
    }

    @DisplayName("컴마(,) 구분자로 입력할 경우 숫자의 합을 반환한다")
    @Test
    void addSeparatedByComma() {
        assertThat(add("1,2")).isEqualTo(3);
    }

    @DisplayName("콜론(:) 구분자로 입력할 경우 숫자의 합을 반환한다")
    @Test
    void addSeparatedByColon() {
        assertThat(add("1:2")).isEqualTo(3);
    }

    @DisplayName(" //와 \\n 사이에 위치하는 문자를 커스텀 구분자로 사용하여 합을 반환한다")
    @Test
    void sumSeparatedByCustom() {
        assertThat(add("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다")
    @Test
    void zeroIfEmpty() {
        assertThat(add("")).isEqualTo(0);
        assertThat(add(" ")).isEqualTo(0);
        assertThat(add(null)).isEqualTo(0);
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw한다")
    @Test
    void throwIfNegative() {
        assertThatThrownBy(() -> {
            Calculator.add("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw한다")
    @Test
    void throwIfNonNumeric() {
        assertThatThrownBy(() -> {
            Calculator.add("a,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
