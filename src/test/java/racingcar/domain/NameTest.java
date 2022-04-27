package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("이름은 5자를 초과 할 수 없다")
    void exceedName() {
        String errorMessage = "이름은 5자를 초과 할 수 없습니다.";

        assertThatThrownBy(() -> new Name("nameExceed"))
            .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage);
    }

    @Test
    @DisplayName("이름은 공백이 될 수 없다")
    void emptyName() {
        String errorMessage = "이름은 공백이 될 수 없습니다.";

        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage);
    }

    @Test
    @DisplayName("글자수 5 이하의 이름을 Wrapping 하는 이름 객체를 만든다")
    void createName() {
        String expect = "abcde";

        Name name = new Name(expect);

        assertThat(name.showName()).isEqualTo(expect);
    }

}
