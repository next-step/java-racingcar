package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarRace;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @Test
    @DisplayName("참가 자동차 확인")
    void createCars() {
        List<Car> cars = new CarRace().createCars(5);

        assertThat(cars).hasSize(5);
        assertThat(cars.get(0)).isEqualTo(new Car(0));
    }

    @Test
    @DisplayName("레이싱 게임 후 결과 size 확인")
    void startRace() {
        List<Car> cars = new CarRace().createCars(5);
        List<Car> racedCars = new CarRace().startRace(3, cars);

        assertThat(racedCars).hasSize(5);
    }
}
