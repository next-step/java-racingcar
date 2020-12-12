package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 0 번 이동")
    void move_0_test() {
        Car car = new Car();
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 랜덤숫자 d일때 이동안함")
    void randomno_3_then_move_0() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤숫자 4일때 자동차 이동")
    void randomno_4_then_move() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}