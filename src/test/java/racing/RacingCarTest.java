package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 자동차_이동거리() {
        Car car = new Car();
        car.move(5);
        car.move(2);
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}
