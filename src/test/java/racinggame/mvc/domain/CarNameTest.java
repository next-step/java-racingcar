package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"crong", "po bi"})
    @DisplayName("5자인 자동차 이름을 허용한다.")
    void 다섯_자인_이름을_허용한다(String name) {
        assertThat(new CarName(name).getValue()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 이름_길이_제한() {
        assertThatThrownBy(() -> new CarName("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t"})
    @DisplayName("비어 있거나 공백만 있는 자동차 이름을 거절한다.")
    void 비어_있거나_공백뿐인_이름을_거절한다(String name) {
        assertThatThrownBy(() -> new CarName(name))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
