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
        car.drive();
        String status = car.getStatus();
        assertFalse(status.isEmpty());
    }
}