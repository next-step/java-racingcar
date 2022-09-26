package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_전진() {
        Car car = new Car();
        assertThat(car.move()).isEqualTo(1);
    }
}