package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 유효성 체크")
    void 유효성() {
        assertThatThrownBy(() -> {
            new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}