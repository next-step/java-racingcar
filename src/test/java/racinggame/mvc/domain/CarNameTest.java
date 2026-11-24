package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    @DisplayName("5자인 자동차 이름을 허용한다.")
    void 다섯_자인_이름을_허용한다() {
        assertThat(new CarName("crong").getValue()).isEqualTo("crong");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 이름_길이_제한() {
        assertThatThrownBy(() -> new CarName("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " pobi", "po bi", "pobi "})
    @DisplayName("자동차 이름은 공백을 포함할 수 없다.")
    void 공백이_있는_이름을_거절한다(String name) {
        assertThatThrownBy(() -> new CarName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
