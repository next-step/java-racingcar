package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void newCarShouldBeWithTrackAndName() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.name).isEqualTo("test");
    }

    @Test
    void carNameShouldBetween1and5() {
        assertThat(new Car("fivee")).isInstanceOf(Car.class);
        assertThatThrownBy(() -> new Car("sixxxx")).isInstanceOf(IllegalArgumentException.class);
    }
}
