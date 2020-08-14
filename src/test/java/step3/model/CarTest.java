package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("차동차 객체 생성 테스트")
    public void makeCarMove() {
        Car car = new Car("밤밤");

        car.makeCarMove();
        car.makeCarMove();
        car.makeCarMove();

        assertThat(car.getCarName()).isEqualTo("밤밤");
        assertThat(car.getCarMovedCount()).isGreaterThan(0);
    }
}