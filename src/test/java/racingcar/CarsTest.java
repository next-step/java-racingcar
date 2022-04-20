package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    @DisplayName("입력한 수 만큼 Car instance를 반환한다.")
    void crateCarTest() {
        assertThat(Cars.createCars(3).getCars()).hasSize(3);
    }

    @Test
    @DisplayName("입력받은 자동차의 갯수는 음수가 될 수 없다.")
    void InputNegativeTest() {
        assertThatThrownBy(() -> Cars.createCars(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 개수는 음수가 될 수 없습니다.");
    }
}
