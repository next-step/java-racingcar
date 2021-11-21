package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 조건을 만족하면 전진한다")
    void shouldIncreasePosition() {
        Car car = new Car();
        RandomNumber randomNumber = new RandomNumber(4);
        car.position(randomNumber.movable());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 조건을 만족하지 않으면 전진하지 않는다")
    void shouldHaveSamePosition() {
        Car car = new Car();
        RandomNumber randomNumber = new RandomNumber(3);
        car.position(randomNumber.movable());

        assertThat(car.getPosition()).isEqualTo(0);
    }
}