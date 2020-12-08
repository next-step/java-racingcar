package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 해당 거리만큼 움직이는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void moveTest(int moveDistance) {
        Car car = new Car(() -> moveDistance);
        car.move();

        assertThat(car.getMovedDistance()).isEqualTo(moveDistance);
    }
}
