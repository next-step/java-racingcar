package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진하면 위치가 증가해야 한다")
    void moveForward_ShouldIncreasePosition() {
        Car car = new Car("Tesla");
        int initialPosition = car.getPosition();
        int newPosition = car.moveForward();
        assertThat(newPosition).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("자동차의 초기 위치는 1이어야 한다")
    void getPosition_ShouldReturnInitialPosition() {
        Car car = new Car("Tesla");
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
