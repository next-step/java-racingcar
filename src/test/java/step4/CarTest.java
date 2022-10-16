package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static step4.Util.separateCarNames;

class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과하면 예외를 던진다")
    void carNameFailTest() {
        assertThatThrownBy(() -> {
            new Car("pobicrong");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자미만이면 예외를 던지지않는다")
    void carNameSuccessTest() {
        assertDoesNotThrow(() -> {
            new Car("p");
        });
    }

    @Test
    @DisplayName("자동차 이름을 구분자로 구분한다")
    void carNameSeparateTest() {
        assertThat(separateCarNames("pobi,crong,honux")).isEqualTo(new String[]{"pobi", "crong", "honux"});
    }
}
