package camp.nextstep.edu.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class StringUtilsTest {

    @Test
    void isEmpty__문자열이_null인_경우_true() {
        final boolean result = StringUtils.isEmpty(null);
        assertThat(result).isTrue();
    }

    @Test
    void isEmpty__문자열이_비어있는_경우_true() {
        final boolean result = StringUtils.isEmpty("");
        assertThat(result).isTrue();
    }

    @Test
    void isEmpty__문자열이_비어있지_않은_경우_false() {
        final boolean result = StringUtils.isEmpty("notEmptyString");
        assertThat(result).isFalse();
    }
}
