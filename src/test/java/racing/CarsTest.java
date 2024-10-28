package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Car;
import racing.service.Cars;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @Test
    void testMoveCars() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Cars racingService = new Cars(Arrays.asList(car1, car2));

        int initialPositionCar1 = car1.getPosition();
        int initialPositionCar2 = car2.getPosition();

        racingService.moveCars();

        assertEquals(calculateExpectedPosition(initialPositionCar1, car1.getPosition()), car1.getPosition());
        assertEquals(calculateExpectedPosition(initialPositionCar2, car2.getPosition()), car2.getPosition());
    }


    private int calculateExpectedPosition(int initialPosition, int currentPosition) {
        if (currentPosition > initialPosition) {
            return initialPosition + 1;
        }
        return initialPosition;
    }

}