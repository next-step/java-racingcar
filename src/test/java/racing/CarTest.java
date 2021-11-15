package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void nameTest() {
        Car car = new Car("joon");
        assertEquals(car.getName().getName(),"joon");
    }

    @Test
    @DisplayName("initial position이 0으로 잘 들어가는지 테스트")
    void initialPositionTest() {
        Car car = new Car("joon");
        assertEquals(car.getPosition().getPosition(), 0);
    }

    @Test
    void moveTest() {
        Car car = new Car("joon");
        car.movable(() -> true);
        assertEquals(car.getPosition().getPosition(), 1);

        Car car2 = new Car("joon");
        car2.movable(() -> false);
        assertEquals(car2.getPosition().getPosition(), 0);

    }

}
