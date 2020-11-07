package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.racingcars.RacingCars;
import study.racingcar.racingcars.RacingCarsSnapshot;
import study.racingcar.racingcars.RacingCarsSnapshotExporter;

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

    @Test
    @DisplayName("RacingCars를 export")
    void test_export() {
        // Given
        List<Car> cars = new ArrayList<Car>();
        Car car = new Car();
        cars.add(car);
        RacingCars racingCars = new RacingCars(cars, new NewEngine());

        racingCars.nextAttempt();

        // When
        RacingCarsSnapshot racingCarsSnapshot = racingCars.export(new RacingCarsSnapshotExporter());

        // Then
        CarSnapshot carSnapshot = racingCarsSnapshot.getCarSnapshot().get(0);
        assertEquals(carSnapshot.getCurrentPosition(), 2);
    }

}