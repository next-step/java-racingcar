package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 0 번 이동")
    void move_0_test() {
        Car car = new Car();
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 5번 이동 후 moveCount = 5")
    void move_3_test() {
        Car car = new Car();
        for(int i = 1; i <= 5; i++) {
            car.move();
        }
        assertThat(car.getMoveCount()).isEqualTo(5);
    }
}