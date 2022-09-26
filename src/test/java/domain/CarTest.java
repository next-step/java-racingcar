package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_random_3이하_미전진() {
        Car car = new Car();
        assertThat(car.move()).isEqualTo(0);
    }

    @Test
    void 자동차_random_4이상_전진() {
        Car car = new Car();
        assertThat(car.move()).isEqualTo(1);
    }
}