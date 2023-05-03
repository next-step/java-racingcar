import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void 전진조건이_아닐_때_이동하지_않는다() {
        int random = 3;

        final Car car = new Car();
        car.move(random);

        assertTrue(car.equalsPosition(0));
    }

    @Test
    void 전진조건일_때_한칸_전진() {
        int random = 4;

        final Car car = new Car();
        car.move(random);

        assertTrue(car.equalsPosition(1));
    }
}
