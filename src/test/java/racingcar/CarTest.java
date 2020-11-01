package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car 이동하기")
    void moveCar() {
        Car car = new Car();

        car.move();

        assertThat(car).hasToString("-");
    }
}
