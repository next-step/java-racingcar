package secondStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {

    @DisplayName(value = "문자열을 배열로 변환한다.")
    @Test
    void split() {
        // given
        String source = "1 + 2";

        // when
        String[] result = StringUtil.split(source);

        // then
        assertThat(result.length).isEqualTo(3);
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