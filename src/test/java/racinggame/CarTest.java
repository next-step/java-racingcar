package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCarTest() {
        var car = Car.create();
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차가 한칸 전진한다.")
    void moveForwardTest() {
        var car = Car.create();
        car.move();
        assertThat(car.getPosition()).isOne();
    }

}