package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진한다.")
    void move() {
        Car car = new Car();

        car.move(true);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
