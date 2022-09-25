package racing.util;

import org.junit.jupiter.api.Test;
import racing.util.CustomUserInputHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomUserInputHandlerTest {
    @Test
    void 음수를_입력했을때_에러() {
        assertThat(CustomUserInputHandler.validate(-1)).isFalse();
    }

    @Test
    void 문자를_입력했을때_에러() {
        assertThat(CustomUserInputHandler.validate("a")).isFalse();
    }

    @Test
    void 숫자를_입력했을때_정상() {
        assertThat(CustomUserInputHandler.validate(3)).isTrue();
    }

    @Test
    void 문자열을_숫자로_변경테스트() {
        assertThat(CustomUserInputHandler.parseInt("1")).isEqualTo(1);
    }

}
