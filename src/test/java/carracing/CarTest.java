package carracing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testCarMovesWhenConditionIsTrue() {
        Car car = new Car();
        assertEquals(0, car.getPosition());
        car.move(true);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void testCarDoesNotMoveWhenConditionIsFalse() {
        Car car = new Car();
        car.move(false);
        assertEquals(0, car.getPosition());
    }
}
