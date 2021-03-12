package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.SignKind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SignKindTest {


    @Test
    void sumTest() {
        int result = SignKind.PLUS.calculate(10, 23);
        assertThat(result).isEqualTo(33);
    }

    @Test
    void minusTest() {
        int result = SignKind.MINUS.calculate(10, 23);
        assertThat(result).isEqualTo(-13);
    }

    @Test
    void multiply() {
        int result = SignKind.MULTIPLY.calculate(10, 23);
        assertThat(result).isEqualTo(230);
    }

    @Test
    void divide() {
        int result = SignKind.DIVIDE.calculate(10, 23);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("기호에 맞는 Enum을 가지고 오는지 확인")
    void getSignTest() {
        String exp = "4 * 1";
        assertThat(SignKind.getSign("*")).isEqualTo(SignKind.MULTIPLY);
    }

    @Test
    @DisplayName("알맞지 않은 문자를 넣으면 오류내는지 확인")
    void getSignErrorTest() {
        assertThatThrownBy(() -> {
            String exp = "4 * 1";
            assertThat(SignKind.getSign("312")).isEqualTo(SignKind.MULTIPLY);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 문자열이 아닙니다.");
    }

}
