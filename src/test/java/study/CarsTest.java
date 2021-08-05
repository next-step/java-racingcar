package study;

import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void getRacingWinnersTest() {
        Car firstCar = new Car("boss", 3);
        Car secondCar = new Car("eddy", 2);
        Car thirdCar = new Car("ram", 1);

        List<Car> racingCars = Arrays.asList(firstCar, secondCar, thirdCar);
        Cars cars = new Cars(racingCars);
        assertThat(cars.getRacingWinners()).containsExactly(firstCar);
    }
}
