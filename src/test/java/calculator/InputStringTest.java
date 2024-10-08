package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputStringTest {

    @Test
    void 입력값은_null이_아니다() {
        assertThatThrownBy(() -> new InputString(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값은_빈문자열이_아니다() {
        assertThatThrownBy(() -> new InputString(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값을_split해서_숫자와_연산자를_담는다() {
        InputString inputString = new InputString("2 + 3 * 4 / 2");
        inputString.split();

        assertThat(inputString.numberCount()).isEqualTo(4);
        assertThat(inputString.operatorCount()).isEqualTo(3);
    }
}
