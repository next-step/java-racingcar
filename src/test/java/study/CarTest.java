package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 이동 테스트")
    @Test
    public void moveCarTest() {
        Car car = new Car();
        car.moveCar();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
