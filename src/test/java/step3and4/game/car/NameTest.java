package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    @DisplayName("이름은 출력할 수 있다.")
    void a() {
        final String value = "12345";
        final Name sut = new Name(value);

        assertThat(sut).hasToString(value + " : ");
    }

}
