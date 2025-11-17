package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @ParameterizedTest
    @CsvSource({"a", "abced"})
    @DisplayName("이름이 유효한 경우")
    void validName(String name) {
        assertThat(new Name(name)).isEqualTo(new Name(name));
    }

    @ParameterizedTest
    @CsvSource({"abcdef", "verylongname"})
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    void carNameShouldThrowExceptionWhenMoreThan5(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자");
    }

    @Test
    @DisplayName("이름이 0자인경우 예외 발생")
    void carNameShouldThrowExceptionWhenLessThan0() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }
}
