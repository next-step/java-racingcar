package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차 이동 시 최소거리 이상 확인")
    void move() {
        Car car = new Car();
        while (car.move() > 0) {
            assertThat(car.getTotalDistance()).isGreaterThan(CarRacingProperty.MIN_MOVABLE_DISTANCE);
            break;
        }
    }

    @Test
    @DisplayName("최종 이동거리 확인")
    void getTotalDistance() {
        Car car = new Car();
        int distance1 = car.move();
        int distance2 = car.move();
        assertThat(car.getTotalDistance()).isEqualTo(distance1 + distance2);
    }

    @Test
    @DisplayName("이동거리 랜덤 범위 확인")
    void getRandomDistance() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            int distance = car.getRandomDistance();
            assertThat(distance).isBetween(CarRacingProperty.MIN_RANDOM_DISTANCE, CarRacingProperty.MAX_RANDOM_DISTANCE);
        }
    }
}
