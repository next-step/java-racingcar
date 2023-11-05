package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    @Test
    void car_랜덤으로_0_9_값을_구할_수_있다() {
        Car car = new Car();
        int randomNumber = car.generateRandomNumber();
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    void car_값이_4이상인_경우_1칸_전진한다() {
        Car car = new Car();
        car.moveCar(car.tryToMove(4));
        assertEquals(car.getDistance(), "-".repeat(2));
    }

    @Test
    void car_값이_4미만인_경우_정지한다() {
        Car car = new Car();
        car.moveCar(car.tryToMove(0));
        assertEquals(car.getDistance(), "-".repeat(1));
    }

    @Test
    void car_주어진_횟수_동안_랜덤값을_구하여_자동차가_전진_혹은_멈출_수_있다() {
        Car car = new Car();
        int position = 1;
        int count = 4;
        for (int i = 0; i < count; i++) {
            int randomNumber = car.generateRandomNumber();
            boolean result = car.tryToMove(randomNumber);
            if (result) {
                car.moveCar(result);
                position++;
            }
        }
        assertEquals(car.getDistance(), "-".repeat(position));
    }
}
