package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("이동 시 위치가 1 증가한다.")
    void move() {
        Car car = new Car();
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 시 위치가 증가하지 않는다.")
    void stay() {
        Car car = new Car();
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
