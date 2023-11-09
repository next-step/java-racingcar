package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @DisplayName("매개변수가 4이상일때만 자동차가 움직이는지 테스트")
    @Test
    void 자동차_이동거리() {
        Car car = new Car();
        car.move(5);
        car.move(2);
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}
