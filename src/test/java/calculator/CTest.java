package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
