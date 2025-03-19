package RacingCar;

import NumberGenerator.TestNumberGenerator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    private static final int MOVE_CONDITION = 4;

    @Test
    void moveShouldIncreasePosition(){
        RacingCar car = new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION));
        car.move();
        assertEquals(1, car.position());
    }

    @Test
    void moveShouldNotIncreasePosition(){
        RacingCar car = new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION-1));
        car.move();
        assertEquals(0, car.position());
    }
}
