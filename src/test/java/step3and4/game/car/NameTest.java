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
}
