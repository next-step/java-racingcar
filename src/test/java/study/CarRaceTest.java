package study;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    public static final int CAR_NUMBER = 100;

    @Test
    void 준비_테스트() {
        List<Car> cars = CarRace.readyCars(CAR_NUMBER);
        assertThat(cars).hasSize(CAR_NUMBER);
    }

    @Test
    void 준비시_위치_테스트() {
        List<Car> cars = CarRace.readyCars(10);

        for (Car car : cars) {
            assertThat(car.getCurrentLocation()).isEqualTo(1);
        }
    }

    @Test
    void 전진_테스트() {
        List<Car> cars = CarRace.readyCars(CAR_NUMBER);
        List<Car> movedCars = CarRace.moveCars(cars);

        assertThat(movedCars).hasSize(100);
        for (int i = 0; i < movedCars.size(); i++) {
            Car before = cars.get(i);
            Car after = movedCars.get(i);
            assertThat(after.getCurrentLocation()).isGreaterThanOrEqualTo(before.getCurrentLocation());

            if (after.getCurrentLocation() > before.getCurrentLocation()) {
                assertThat(after.getCurrentLocation()).isEqualTo(before.getCurrentLocation() + 1);
            }
        }
    }

    @Test
    void 전진_가능_로직_테스트() {
        Car before = new Car(1);

        Car after = CarRace.moveOrStop(before);

        assertThat(after.getCurrentLocation()).isGreaterThanOrEqualTo(before.getCurrentLocation());

        if (after.getCurrentLocation() > before.getCurrentLocation()) {
            assertThat(after.getCurrentLocation()).isEqualTo(before.getCurrentLocation() + 1);
        }
    }
}
