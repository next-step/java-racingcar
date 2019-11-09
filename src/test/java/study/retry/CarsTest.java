package study.retry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retry.domain.Car;
import retry.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars racingCars;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("test", 0), new Car("test1", 0), new Car("test2", 0));
        this.racingCars = new Cars(cars);
    }

    @Test
    void racingCarsContainsTest() {
        assertThat(racingCars.contains(new Car("test", 0))).isTrue();
        assertThat(racingCars.contains(new Car("test", 1))).isFalse();
    }

    @Test
    void moveTest() {
        Cars newRacingCars = racingCars.moveCarsPositionByInterface();
        assertThat(racingCars).isNotEqualTo(newRacingCars);
    }

    @Test
    void initiateTest() {
        String carNameWithComma = "test1,test2,test3";
        Cars cars = new Cars(carNameWithComma);
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.contains(new Car("test1", 0))).isTrue();
        assertThat(cars.contains(new Car("test2", 0))).isTrue();
        assertThat(cars.contains(new Car("test3", 0))).isTrue();
    }

    @Test
    void getWinnerPositionValueTest() {
        Cars cars = new Cars(Arrays.asList(new Car("test", 1), new Car("test1", 3), new Car("test2", 2)));
        assertThat(cars.getWinnerPositionValue()).isEqualTo(3);
    }
}
