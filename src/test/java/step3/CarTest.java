package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("이동 테스트")
    void moveTest() {
        Car car = new Car();
        car.randomNumber();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}