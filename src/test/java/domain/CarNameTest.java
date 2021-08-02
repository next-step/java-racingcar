package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarNameTest {

    @DisplayName("자동차 이름 정상 테스트")
    @Test
    void carNameCheckTest() {
        CarName carName = new CarName("name");
        assertThat(carName.readCarName()).isEqualTo("name");
    }

    @DisplayName("자동차 이름 5이상 예외 테스트")
    @Test
    void carNameOverExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName("namename"))
                .withMessageMatching("자동차 이름은 1이상 5이하여야 합니다.");
    }

    @DisplayName("자동차 이름 1미만 예외 테스트")
    @Test
    void carNameUnerExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(""))
                .withMessageMatching("자동차 이름은 1이상 5이하여야 합니다.");
    }

}