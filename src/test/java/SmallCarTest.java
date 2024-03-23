import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jeongheekim
 * @date 3/18/24
 */
class SmallCarTest {
    @Test
    @DisplayName("drive 메서드가 호출 되면 status는 empty가 아니다.")
    void whenDriveStatusMoreThan1() {
        SmallCar car = new SmallCar();
        car.drive(car.getNumber());
        String status = car.getStatus();
        assertFalse(status.isEmpty());
    }

    @Test
    @DisplayName("random 값이 4이상일 경우 앞으로 전진한다.")
    void whenRandom4goDriveTest() {
        SmallCar car = new SmallCar();
        assertTrue(car.getNumber() >= 4);
    }

}
