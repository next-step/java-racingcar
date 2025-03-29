package carracing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 테스트(이동 조건이 True일 때)")
    public void MoveCarTest1() {
        Car car = new Car("TEST");
        assertEquals(0, car.getPosition());
        car.move(true);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이동 테스트(이동 조건이 False일 때)")
    public void MoveCarTest2() {
        Car car = new Car("TEST");
        car.move(false);
        assertEquals(0, car.getPosition());
    }
}
