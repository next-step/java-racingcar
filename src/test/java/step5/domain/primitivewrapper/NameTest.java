package step5.domain.primitivewrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("원시 값으로 포장된 Name을 생성한다.")
    @Test
    void createNameWrapper() {
        // given
        String inputName = "abc";

        // when
        Name name = new Name(inputName);

        // then
        assertThat(name.toString()).isEqualTo("abc");
    }

    @DisplayName("이름이 5글자를 초과하면 예외를 던진다.")
    @Test
    void validateNameIsMoreThanFiveChar() {
        // given
        String name = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("이름이 빈 문자열이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsNone(String name) {
        // when & then
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 빈 문자열이 될 수 없습니다.");
    }
}