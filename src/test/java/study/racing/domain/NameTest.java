package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름이 5글자가 넘어서면 IllegalArgumentException이 발생한다.")
    void nameLengthTest() {
        // given
        String input = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이를 벗어났습니다.");

    }
}
