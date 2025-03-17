package step2;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다")
    @Test
    void zeroIfEmpty() {
        int actual = calculator.add("");

        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("null을 입력할 경우 0을 반환한다")
    @Test
    void zeroIfNull() {
        int actual = calculator.add(null);

        assertThat(actual).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void getNumberFromString() {
        int actual = calculator.add("1");

        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("숫자 2개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @Test
    void sumSeparatedByComma() {
        int actual = calculator.add("1,2");

        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("구분자 컴마(,)와 콜론(:)을 사용하여 세 숫자의 합을 반환한다")
    @Test
    void sumSeparatedByCommaAndColon() {
        int actual = calculator.add("1,2:3");

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName(" //와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용하여 합을 반환한다")
    @Test
    void sumSeparatedByCustom() {
        int actual = calculator.add("//;\n1;2;3");

        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw한다")
    @Test
    void throwIfNegative() {
        assertThatThrownBy(() -> {
            calculator.add("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw한다")
    @Test
    void throwIfNonNumeric() {
        assertThatThrownBy(() -> {
            calculator.add("a,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("커스텀 구분자와 함께 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw한다")
    @Test
    void throwIfNonNumericCustomDelimiter() {
        assertThatThrownBy(() -> {
            calculator.add("//;\na;2;3");
        }).isInstanceOf(RuntimeException.class);
    }

}
