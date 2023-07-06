package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    @Test
    @DisplayName("입력 받은 문자열이 양수")
    void 입력_받은_문자열이_양수() {
        PositiveNumber positiveNumber = new PositiveNumber("3");

        int number = positiveNumber.getValue();

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 받은 문자열이 음수")
    void 입력_받은_문자열이_음수() {
        assertThatThrownBy(() -> new PositiveNumber("-3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 음수일 수 없습니다.");
    }
}