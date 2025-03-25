package RacingCar.model;

import NumberGenerator.TestNumberGenerator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    private static final int MOVE_CONDITION = 4;
    private static final String TEST_CAR_NAME = "TEST_CAR";
    @Test
    void moveShouldIncreasePosition(){
        RacingCar car = new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION), TEST_CAR_NAME);
        car.move();
        assertEquals(1, car.position());
    }

    @Test
    void moveShouldNotIncreasePosition(){
        RacingCar car = new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION-1), TEST_CAR_NAME);
        car.move();
        assertEquals(0, car.position());
    }
}
