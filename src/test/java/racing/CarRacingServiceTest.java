package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Car;
import racing.service.CarRacingService;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRacingServiceTest {

    @Test
    void testMoveCars() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        CarRacingService racingService = new CarRacingService(Arrays.asList(car1, car2));

        int initialPositionCar1 = car1.getPosition();
        int initialPositionCar2 = car2.getPosition();

        racingService.moveCars();

        assertEquals(initialPositionCar1 + (car1.getPosition() > initialPositionCar1 ? 1 : 0), car1.getPosition());
        assertEquals(initialPositionCar2 + (car2.getPosition() > initialPositionCar2 ? 1 : 0), car2.getPosition());
    }
}
