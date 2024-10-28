package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Car;
<<<<<<< HEAD
<<<<<<< HEAD
import racing.service.Cars;
=======
import racing.service.CarRacingService;
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======
import racing.service.Cars;
>>>>>>> 090df7a39 (fix: 테스트 수정)
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @Test
    void testMoveCars() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
<<<<<<< HEAD
<<<<<<< HEAD
        Cars racingService = new Cars(Arrays.asList(car1, car2));
=======
        CarRacingService racingService = new CarRacingService(Arrays.asList(car1, car2));
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======
        Cars racingService = new Cars(Arrays.asList(car1, car2));
>>>>>>> 090df7a39 (fix: 테스트 수정)

        int initialPositionCar1 = car1.getPosition();
        int initialPositionCar2 = car2.getPosition();

        racingService.moveCars();

<<<<<<< HEAD
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
=======
        assertEquals(calculateExpectedPosition(initialPositionCar1, car1.getPosition()), car1.getPosition());
        assertEquals(calculateExpectedPosition(initialPositionCar2, car2.getPosition()), car2.getPosition());
>>>>>>> 090df7a39 (fix: 테스트 수정)
    }


    private int calculateExpectedPosition(int initialPosition, int currentPosition) {
        if (currentPosition > initialPosition) {
            return initialPosition + 1;
        }
        return initialPosition;
    }

}
<<<<<<< HEAD
>>>>>>> 6186238e5 (feat: 테스트 작성)
=======

>>>>>>> 090df7a39 (fix: 테스트 수정)
