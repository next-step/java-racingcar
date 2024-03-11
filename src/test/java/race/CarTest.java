package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void car_twice_forward() {
        Car car = new Car();
        assertThat(car.goForward(2)).isEqualTo("--");
    }

    @Test
    void car_forward() {
        Car car = new Car();
        assertThat(car.goForward(1)).isEqualTo("-");
    }
}
