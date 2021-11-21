package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("0에서 9 사이의 랜덤 값을 생성한다")
    void shouldIncreasePosition() {
        Car car = new Car();
        int randomNumber = 4;
        car.position(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void shouldHaveSamePosition() {
        Car car = new Car();
        int randomNumber = 3;
        car.position(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}