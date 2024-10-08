package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Car;
<<<<<<< HEAD
import racing.service.Cars;
=======
import racing.service.CarRacingService;
>>>>>>> 6186238e5 (feat: 테스트 작성)
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRacingServiceTest {

    @Test
    void testMoveCars() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
<<<<<<< HEAD
        Cars racingService = new Cars(Arrays.asList(car1, car2));
=======
        CarRacingService racingService = new CarRacingService(Arrays.asList(car1, car2));
>>>>>>> 6186238e5 (feat: 테스트 작성)

        int initialPositionCar1 = car1.getPosition();
        int initialPositionCar2 = car2.getPosition();

        racingService.moveCars();

<<<<<<< HEAD
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

=======
        assertEquals(initialPositionCar1 + (car1.getPosition() > initialPositionCar1 ? 1 : 0), car1.getPosition());
        assertEquals(initialPositionCar2 + (car2.getPosition() > initialPositionCar2 ? 1 : 0), car2.getPosition());
    }
}
>>>>>>> 6186238e5 (feat: 테스트 작성)
