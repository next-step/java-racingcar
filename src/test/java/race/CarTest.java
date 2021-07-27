package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("car distance check Test")
    void carDistanceCheckTest() {
        car.go();
        assertThat(car.totalDistance()).isEqualTo(1);
    }
}
