package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 경우 GO 반환")
    void movementStatus_GO() {
        String movementStatus = car.getMovementStatus(5);
        assertEquals(Car.GO, movementStatus);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만일 경우 STOP 반환")
    void movementStatus_STOP() {
        String movementStatus = car.getMovementStatus(3);
        assertEquals(Car.STOP, movementStatus);
    }
}
