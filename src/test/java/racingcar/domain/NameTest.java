package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @Test
    @DisplayName("생성 validation 체크")
    void validTrue() {
        // given
        String trueName = "abcde";

        // when

        // then
        assertThatCode(() -> new Name(trueName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("생성 validation 체크")
    void validFalse() {
        // given
        String falseName = "ttokey";

        // when

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(falseName);
        });
    }
}
