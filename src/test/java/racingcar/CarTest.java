package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 이동, 4미만이면 정지")
    public void move() {
        Car car = new Car("kb");

        car.move(4);
        assertThat(car.getMovingDistance()).isEqualTo(1);

        car.move(3);
        assertThat(car.getMovingDistance()).isEqualTo(1);
    }
}
