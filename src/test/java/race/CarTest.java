package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void car() {
        Car car = new Car(1);
        assertThat(car.goForward(1)).isEqualTo("-");
    }
}
