package camp.nextstep.edu.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class AssertUtilsTest {
    @Test
    void 입력받은_값이_null이면_IllegalArgumentException을_던져야함() {
        final String errorMessage = "object must not be null";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> AssertUtils.notNull(null, errorMessage))
                .withMessageMatching(errorMessage);
    }

    @Test
    void 입력값은_값이_null이_아니면_IllegalArgumentException을_던지지_않아야함() {
        final Object notNullObject = new Object();
        assertThatCode(() -> AssertUtils.notNull(notNullObject, "object must not be null"))
                .doesNotThrowAnyException();
    }
}
