package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4이상일 경우 전진")
    @Test
    void moveTest() {
        Car car = new Car();
        car.move();

        assertThat(car.getPosition()).isBetween(0,1);
    }
}
