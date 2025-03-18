package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진하면 위치가 증가해야 한다")
    void moveForward_ShouldIncreasePosition() {
        Car car = new Car();
        int initialPosition = car.getPosition();
        int newPosition = car.moveForward();
        assertEquals(initialPosition + 1, newPosition);
    }

    @Test
    @DisplayName("자동차의 초기 위치는 1이어야 한다")
    void getPosition_ShouldReturnInitialPosition() {
        Car car = new Car();
        assertEquals(1, car.getPosition());
    }
}
