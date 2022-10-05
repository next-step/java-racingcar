package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름은 출력할 수 있다.")
    void a() {
        final String value = "12345";
        final Name sut = new Name(value);

        assertThat(sut).hasToString(value + " : ");
    }

    @Test
    @DisplayName("이름은 5글자를 초과할 수 없다.")
    void b() {
        final Name sut = new Name("123456");

        assertThatThrownBy(() -> sut.verifyLengthMustNotExceedFive())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");
    }
}
