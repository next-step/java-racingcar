package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차 이동 시 최소거리 이상 확인")
    void move() {
        Car car = new Car();
        int distance = car.getDistance();
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(distance);
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(distance + 1);
    }

    @Test
    @DisplayName("최종 이동거리 확인")
    void getTotalDistance() {
        Car car = new Car();
        car.move(9);
        car.move(9);
        assertThat(car.getDistance()).isEqualTo(2);
    }

}
