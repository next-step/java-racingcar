package racingcar;

import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("전진")
    @Test
    void car_주어진_횟수_동안_랜덤값을_구하여_자동차가_전진할_수_있다() {
        Car car = new Car();
        int position = 2;

        int randomNumber = 4;
        boolean result = car.tryToMove(randomNumber);
        car.moveCar(result);
        assertEquals(car.getPosition(), position);
    }

    @DisplayName("정지")
    @Test
    void car_주어진_횟수_동안_랜덤값을_구하여_자동차가_멈출_수_있다() {
        Car car = new Car();
        int position = 1;

        int randomNumber = 1;
        boolean result = car.tryToMove(randomNumber);
        car.moveCar(result);
        assertEquals(car.getPosition(), position);
    }
}
