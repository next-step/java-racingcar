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

    @BeforeEach
    void setUp() {
        List<Car> cars = Arrays.asList(new Car("test", 0), new Car("test1", 0), new Car("test2", 0));
        this.racingCars = new Cars(cars);
    }

    @Test
    void racingCarsContainsTest() {
        assertThat(racingCars.contains(new Car("test", 0))).isTrue();
        assertThat(racingCars.contains(new Car("test", 1))).isFalse();
    }

    @Test
    void racingCarsMoveTest() {
        List<Car> cars = racingCars.moveCarsPositionByInterface(() -> true);
        assertThat(cars.contains(new Car("test", 1))).isTrue();
        assertThat(cars.contains(new Car("test1", 1))).isTrue();
        assertThat(cars.contains(new Car("test2", 1))).isTrue();
    }
}
