package secondStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {

    @DisplayName(value = "문자열을 배열로 변환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2,3", "1 + 2 / 2,5"})
    void split(String str, int length) {
        // given
        String source = str;

        // when
        String[] result = StringUtil.split(source);

        // then
        assertThat(result.length).isEqualTo(length);
    }

    @DisplayName(value = "null or empty IllegalArgumentException")
    @Test
    void validateNone() {
        // given
        String emptySource = "";
        String nullSource = null;

        // when
        assertThatThrownBy(() -> {
            StringUtil.split(emptySource);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 문자열을 사용할 수 없습니다.");

        // when
        assertThatThrownBy(() -> {
            StringUtil.split(nullSource);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("NULL을 사용할 수 없습니다.");

    }
}