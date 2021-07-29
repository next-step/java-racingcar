package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {
    @Test
    @DisplayName("자동차 이름 제약조건 테스트")
    void isValidCarNameTest() {
        assertThat(CarName.isValidCarName("Car")).isTrue();
        assertThat(CarName.isValidCarName("Caar")).isTrue();
        assertThat(CarName.isValidCarName("Caaar")).isTrue();
        assertThat(CarName.isValidCarName("Caaaar")).isFalse();
    }
}
