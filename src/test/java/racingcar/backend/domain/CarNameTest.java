package racingcar.backend.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("이름이 5글자 이상 ERROR")
    void error_over_5_characters() {
        assertThatThrownBy(() -> new CarName("kimjio"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과");
    }
}
