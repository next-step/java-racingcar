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

    @Test
    @DisplayName("GO 상태일 때 updatePosition 메서드를 호출하면 position은 -가 추가된다.")
    void updatePosition_GO() {
        Car car = new Car();
        car.updatePosition(Car.GO);
        assertEquals(Car.GO, car.getPosition());
    }

    @Test
    @DisplayName("STOP 상태일 때 updatePosition 메서드를 호출하면 position은 변하지 않는다.")
    void updatePosition_STOP() {
        Car car = new Car();
        car.updatePosition(Car.STOP);
        assertEquals("", car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 9일 때 GO 상태로 이동")
    void move_GO() {
        Car car = createCar(9);
        car.move();
        assertEquals(Car.GO, car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 1일 때 STOP 상태로 이동")
    void move_STOP() {
        Car car = createCar(1);
        car.move();
        assertEquals("", car.getPosition());
    }

    private Car createCar(int randomNumber) {
        return new Car() {
            @Override
            protected int generateRandomNumber() {
                return randomNumber;
            }
        };
    }
}
