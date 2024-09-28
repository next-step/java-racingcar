package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("1대의 자동차를 n만큼 움직일 수 있다.")
    @Test
    void moveCar() {
        // given
        Car car = new Car();

        // when
        car.move(3);

        // then
        assertThat(car.getDistance()).isEqualTo(3);
    }

}
