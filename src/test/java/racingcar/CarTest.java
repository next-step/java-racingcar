package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void newCarShouldBeWithTrackAndName() {
        Car car = new Car("testName");
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.name).isEqualTo("testName");
    }
}
