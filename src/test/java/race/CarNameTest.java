package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import race.car.CarName;

class CarNameTest {

    @Test
    void 생성() {
        CarName carName = new CarName("pobi");

        assertThat(carName).isEqualTo(new CarName("pobi"));
    }

    @Test
    void CarName은_5글자를_넘지_않는다() {
        assertThatThrownBy(() -> new CarName("testCar"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 너무 깁니다");
    }
}
