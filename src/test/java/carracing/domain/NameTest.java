package carracing.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차자동차", "자동차자동차자동차"})
    @DisplayName("이름이 limit len이하가 아니라면 exception이 발생해야 한다.")
    void nameByInvalidLengthTest(String input) {

        // given
        int len = 5;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(input, len))
            .withMessageMatching("이름은 " + len + " 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("이름이 공백이 들어오면 exception이 발생해야 한다.")
    void nameByBlankTest(String input) {

        // given
        int len = 0;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(input, len))
            .withMessageMatching("이름은 공백이 들어올 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 null이 들어오면 exception이 발생해야 한다.")
    void nameByNullTest() {

        // given
        String input = null;
        int len = 0;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name(input, len))
            .withMessageMatching("이름은 공백이 들어올 수 없습니다.");
    }

}
