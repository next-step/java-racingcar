package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class CarsTest {

    private Cars cars;
    private List<Car> rawCars;

    @BeforeEach
    void setUp() {
        Car pobi = new Car(1);
        Car crong = new Car(2);
        Car honux = new Car(3);
        rawCars = Arrays.asList(pobi, crong, honux);
        cars = new Cars(rawCars);
    }

    @Test
    void move() {
//        List<Car> movedCarList = rawCars
//                .stream()
//                .map(car -> car.move(() -> true))
//                .collect(Collectors.toList());
        List<Car> movedCarList = Arrays.asList(new Car(2), new Car(3), new Car(4));
        Cars expected = new Cars(movedCarList);
        assertThat(cars.move(() -> true)).isEqualTo(expected);
    }

    @Test
    void stop() {
        Cars expected = new Cars(rawCars);
        assertThat(cars.move(() -> false)).isEqualTo(expected);
    }
}
