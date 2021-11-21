package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    void shouldIncreasePosition() {
        Car car = new Car();
        int randomNumber = 4;
        car.position(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 전진하지 않는다")
    void shouldHaveSamePosition() {
        Car car = new Car();
        int randomNumber = 3;
        car.position(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}