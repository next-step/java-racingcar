package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.CarModel;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    CarModel car = new CarModel();

    @Test
    @DisplayName("car distance check Test")
    void carDistanceCheckTest() {
        car.go();
        assertThat(car.totalDistance()).isEqualTo(1);
    }
}
