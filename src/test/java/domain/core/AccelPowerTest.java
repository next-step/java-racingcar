package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccelPowerTest {

    @Test
    @DisplayName("AccelPower 생성 테스트")
    void constructor() {
        //given
        int expectedPower = 5;
        int power = 0;
        Accelerator accelPower = new Accelerator(5);

        //when
        power = accelPower.getPower();

        //then
        assertEquals(expectedPower, power);
    }
}
