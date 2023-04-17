package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCarTest() {
        final int MOVE_DISTANCE = 1;
        Car car = new Car();
        car.move();
        assertThat(car.getLocation()).isEqualTo(MOVE_DISTANCE);
    }
}
