package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void newCarShouldBeWithTrackAndName() {
        Car car = new Car("testName");
        assertThat(car.getTrack()).isEqualTo("-");
        assertThat(car.name).isEqualTo("testName");
    }

    @Test
    void setTrackForTest() {
        Car car = new Car("testName");
        car.setTrackForTest("---");
        assertThat(car.getTrack()).isEqualTo("---");
    }
}
