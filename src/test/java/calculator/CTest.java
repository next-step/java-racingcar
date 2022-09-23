package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CTest {
    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다")
    void null_check() {
        int result = C.calculator("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("null값을 입력할 경우 0을 반환한다")
    public void null_check2() {
        int result = C.calculator(null);
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void inputString() {
        int number = C.calculator("1");
        assertThat(number).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void inputStringArr() {
        assertThat(C.calculator("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있ㄴ")
    void regex() {
        assertThat(C.calculator("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void customRegex() {
        assertThat(C.calculator("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void negativeNumberException() {
        assertThatThrownBy(() -> C.calculator("-1:2:3"))
                .isInstanceOf(RuntimeException.class);

    }
}
