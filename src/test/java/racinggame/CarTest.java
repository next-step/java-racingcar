package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 전진하면 위치가 1 증가한다.")
    @Test
    void move() {
        Car car = new Car();
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
