package laststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laststep.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @DisplayName("이름에 공백입력 시 예외 발생")
    @ValueSource(strings = {"", " ", "          "})
    void validBlank(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백은 입력할 수 없어요");
    }

    @Test
    @DisplayName("이름 5자 초과시 예외 발생")
    void validLength() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없어요");
    }

    @Test
    @DisplayName("이름 1자 이상 5자 이하 이름 생성 완료")
    void successLength() {
        Name actual = new Name("pobi");
        assertThat(actual).isEqualTo(new Name("pobi"));
    }
}
