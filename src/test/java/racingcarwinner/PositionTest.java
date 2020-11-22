package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    @DisplayName("포지션 값을 제대로 가져오는가?")
    public void getPositionTest(){
        Car car = new Car("베니");

        assertTrue(car.getPosition().getValue() == 0);
        car.move();
        assertFalse(car.getPosition().getValue() == 0);
        assertTrue(car.getPosition().getValue() == 1);
    }

    @Test
    @DisplayName("증가된 포지션 값을 재대로 가져오는가?")
    public void getIncreaseValueTest(){
        Position position = new Position(0);
        assertTrue(position.getIncreaseValue() == 1);

    }
}
