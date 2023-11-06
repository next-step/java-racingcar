package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {

    @Test
    void car_값이_4이상인_경우_1칸_전진한다() {
        Car car = new Car();
        car.moveCar(car.tryToMove(4));
        assertEquals(car.getPosition(), 2);
    }

    @Test
    void car_값이_4미만인_경우_정지한다() {
        Car car = new Car();
        car.moveCar(car.tryToMove(0));
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void car_주어진_횟수_동안_랜덤값을_구하여_자동차가_전진_혹은_멈출_수_있다() {
        Car car = new Car();
        int position = 1;

        int randomNumber = car.generateRandomNumber();
        boolean result = car.tryToMove(randomNumber);
        if (result) {
            car.moveCar(result);
            position++;
        }

        assertEquals(car.getPosition(), position);
    }
}
