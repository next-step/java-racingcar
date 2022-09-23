package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("숫자 입력시 0인 경우 익셉션 처리한다.")
    @Test
    void input_zero() {

        assertThatThrownBy(() -> Number.from("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1 이상이어야 합니다.");
    }

    @DisplayName("숫자 입력시 문자가 포함된 경우 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"d1", "te"})
    void input_string(final String str) {

        assertThatThrownBy(() -> Number.from(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }
}