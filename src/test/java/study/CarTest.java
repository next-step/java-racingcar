package study;

import org.junit.jupiter.api.Test;
import racing.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car = new Car();

    @Test
    void 주행거리() {
        assertThat(car.distance()).isEqualTo(0);
    }

    @Test
    void 전진하면_주행거리_올라감() {
        assertThat(car.distance()).isEqualTo(0);
        car.run();
        assertThat(car.distance()).isEqualTo(1);
    }
}
