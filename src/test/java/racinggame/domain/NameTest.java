package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @ParameterizedTest
    @CsvSource({"a", "abcde"})
    @DisplayName("이름이 유효한 경우")
    void validName(String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

    @Test
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    void carNameShouldThrowExceptionWhenMoreThan5() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null 또는 빈 문자열")
    void carNameShouldThrowExceptionWhenLessThan0(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }
}
