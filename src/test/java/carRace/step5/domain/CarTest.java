package carRace.step5.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car car = new Car("test", 4);
    @Test
    void 이동(){
        car.moveCar(5);

        assertEquals(car.getMoveDistance(), 5);
    }

    @Test
    void 정지(){
        car.moveCar(3);

        assertEquals(car.getMoveDistance(), 4);
    }
}
