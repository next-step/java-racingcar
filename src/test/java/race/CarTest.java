package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 거리를 움직이는지 확인한다.")
    @Test
    void moveTest() {
        Car car = new Car(() -> 1);
        car.move();

        assertThat(car.getMovedDistance()).isEqualTo(1);
    }
}
