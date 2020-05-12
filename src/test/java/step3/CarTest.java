package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        // given
        Car car = new Car();

        // when
        car.move();

        // then
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }
}
