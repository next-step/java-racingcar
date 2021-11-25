package carracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    @Test
    void stepForward() {
        Car car = new Car("car");
        car.stepForward(() -> true);
        assertThat(car.getStep()).isEqualTo(1);
    }

    @Test
    void nonStepForward() {
        Car car = new Car("car");
        car.stepForward(() -> false);
        assertThat(car.getStep()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void severalStepForwardAlwaysGo(int round) {
        Car car = new Car("name");
        for (int i = 0; i < round; i++) {
            car.stepForward(() -> true);
        }
        assertThat(car.getStep()).isEqualTo(round);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    void severalStepForwardNeverGo(int round) {
        Car car = new Car("name");
        for (int i = 0; i < round; i++) {
            car.stepForward(() -> false);
        }
        assertThat(car.getStep()).isEqualTo(0);
    }

    @Test
    void carWithCarName() {
        Car car = new Car(new CarName("name"));
        CarName carName = car.getCarName();
        assertThat(carName.getName()).isEqualTo("name");
    }
}
