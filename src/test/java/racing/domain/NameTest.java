package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("5글자 이하 제한 확인")
    void name() {
        // given
        String input = "pobi";

        // when
        Name name = new Name(input);

        // then
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(strings = {"", " "})
    @DisplayName("이름을 입력하지 않았을 때")
    void name2(String input) {
        // when
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1글자 이상이어야 합니다.");
    }

}