package racing.utils;

import javajigi.racinggame.utils.ValidationUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @Test
    void validName() {
        assertThat(ValidationUtils.validName("a")).isTrue();
        assertThat(ValidationUtils.validName("abcde")).isTrue();
    }

    @Test
    void invalidName() {
        assertThat(ValidationUtils.validName("abcdef")).isFalse();
        assertThat(ValidationUtils.validName(" ")).isFalse();
        assertThat(ValidationUtils.validName(null)).isFalse();
    }
}