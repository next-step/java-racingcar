package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    @DisplayName("숫자로 파싱할 수 있는 문자열인지 확인")
    void 숫자로_파싱할_수_있는_문자열인지_확인() {
        Number number = new Number("3");

        int value = number.getValue();

        assertThat(value).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자로 파싱할 수 없다면 RuntimeException")
    void 숫자로_파싱할_수_없다면_RuntimeException() {

        Assertions.assertThatThrownBy(() -> new Number("a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자만 입력해야합니다.");
    }
}