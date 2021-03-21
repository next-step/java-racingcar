package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @Test
    @DisplayName("생성 validation 체크")
    void valid() {
        // given
        String trueName = "abcde";
        String falseName = "ttokey";

        // when

        // then
        assertThatCode(() -> new Name(trueName)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(falseName);
        });
    }
}
