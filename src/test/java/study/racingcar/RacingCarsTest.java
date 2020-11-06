package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.car.Car;
import study.racingcar.car.Engine;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("게임의 회차를 진행")
    void test_nextAttempt() {
        // Given
        List<Car> cars = new ArrayList<Car>();
        Car car = new Car();
        cars.add(car);
        RacingCars racingCars = new RacingCars(cars, new NewEngine());

        // When
        racingCars.nextAttempt();

        // Then
        assertEquals(car.getCurrentPosition(), 2);
    }


}