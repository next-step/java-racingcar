package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이동이 성공하면, distance 가 상승한다.")
    void distanceTest() {
        Car car = new Car();

        for (int i = 0; i < 10; i++) {
            car.attemptMove();
        }

        assertThat(car.getCarCurrentDistance()).isGreaterThan(0);
    }

}
