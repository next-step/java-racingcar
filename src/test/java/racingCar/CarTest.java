package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_처음_위치_0() {
        Assertions.assertThat(new Car().getPosition()).isEqualTo(0);
    }
}
