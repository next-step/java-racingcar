package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차가 움직이면, 자동차의 움직인 거리만큼 위치가 변한다")
    @Test
    void move() {
        Car car = new Car("pobi");
        car.move(0);
        assertThat(car.getCurrentPosition()).isEqualTo(0);

        car.move(3);
        assertThat(car.getCurrentPosition()).isEqualTo(3);

        car.move(2);
        assertThat(car.getCurrentPosition()).isEqualTo(5);
    }

}