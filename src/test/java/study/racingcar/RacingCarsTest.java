package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.car.Car;
import study.racingcar.domain.car.CarName;
import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.racingcars.RacingCars;
import study.racingcar.domain.racingcars.RacingCarsSnapshot;
import study.racingcar.domain.racingcars.RacingCarsSnapshotExporter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("게임의 회차를 진행")
    void test_nextAttempt() {
        // Given
        List<Car> cars = new ArrayList<Car>();
        Car car = initCar();
        cars.add(car);
        RacingCars racingCars = new RacingCars(cars, new NewEngine());

        // When
        racingCars.nextAttempt();

        // Then
        assertEquals(car.getCurrentPosition(), 1);
    }

    @Test
    @DisplayName("RacingCars를 export")
    void test_export() {
        // Given
        List<Car> cars = new ArrayList<Car>();
        cars.add(initCar());
        RacingCars racingCars = new RacingCars(cars, new NewEngine());

        racingCars.nextAttempt();

        // When
        RacingCarsSnapshot racingCarsSnapshot = racingCars.export(new RacingCarsSnapshotExporter());

        // Then
        CarSnapshot carSnapshot = racingCarsSnapshot.getCarSnapshot().get(0);
        assertEquals(carSnapshot.getCurrentPosition(), 2);
    }
    
    @Test
    @DisplayName("선두주자 찾기")
    void test_whoIsFrontRunners() {
        // Given
        List<Car> cars = new ArrayList<Car>();
        cars.add(initCar());
        RacingCars racingCars = new RacingCars(cars, new NewEngine());

        racingCars.nextAttempt();

        // When
        List<Car> frontRunners = racingCars.whoIsFrontRunners();

        // Then
        Car frontRunner = frontRunners.get(0);
        assertEquals(frontRunner.getCurrentPosition(), 1);
    }
    
    private Car initCar() {
        return new Car(new CarName("test"));
    }
}