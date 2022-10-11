package step3and4and5.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름은 출력할 수 있다.")
    void a() {
        final String value = "12345";
        final Name sut = new Name.Factory(value).name();

        assertThat(sut.print()).isEqualTo(value + " : ");
    }

    @Test
    @DisplayName("이름은 5글자를 초과할 수 없다.")
    void b() {
        assertThatThrownBy(() -> new Name.Factory("123456").name())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    @DisplayName("이름 유효성 검증")
    void c(String value) {
        assertThatThrownBy(() -> new Name.Factory(value).name())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름이 null 값이거나 공백일 수 없습니다.");
    }
}
