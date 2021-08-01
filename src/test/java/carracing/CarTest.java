package carracing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 위치가 자동차에 저장되어있어야 한다.")
    void carLocationTest() {

        // given
        Car car = new Car();

        // whe & then
        assertThat(car.location()).isEqualTo("");
    }

    @Test
    @DisplayName("자동차는 이동할 수 있다.")
    void forwardCarTest() {

        // given
        Car car = new Car();

        // when
        car.forward();

        // then
        assertThat(car.location()).isEqualTo("-");
    }

}