import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름은 5글자 이하여야 한다.")
    void validCarNameTest() {
       assertThat(new CarName("12345")).isEqualTo(new CarName("12345"));
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 실패한다.")
    void invalidCarNameTest() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}