package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.RacingCarTestUtil.*;

public class CarsTest {

    private Cars cars;
    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory(NAMES_OF_CARS);
    }

    @Test
    void add() {
        cars = new Cars();
        cars.add(new Car(NAME_OF_CAR));
        assertThat(cars.size()).isEqualTo(INDICATOR_OF_ONE_CAR);
        assertThat(cars.contains(new Car(NAME_OF_CAR))).isTrue();
    }

    @Test
    void contains() {
        cars = carFactory.buildCars();
        assertThat(cars.contains(new Car("pobi"))).isTrue();
        assertThat(cars.contains(new Car("tomo"))).isTrue();
        assertThat(cars.contains(new Car("crong"))).isTrue();
        assertThat(cars.contains(new Car("honux"))).isTrue();
        assertThat(cars.contains(new Car("yong"))).isTrue();
        assertThat(cars.contains(new Car("dane"))).isFalse();
    }

    @Test
    void stream() {
        cars = carFactory.buildCars();
        AtomicInteger runCount = new AtomicInteger(INITIAL_COUNT);
        cars.stream().forEach(car -> runCount.incrementAndGet());
        assertThat(runCount.get()).isEqualTo(NUMBER_OF_CARS);
    }

    @Test
    void size() {
        cars = carFactory.buildCars();
        assertThat(cars.size()).isEqualTo(NUMBER_OF_CARS);
    }

    @Test
    void clear() {
        cars = carFactory.buildCars();
        cars.clear();
        assertThat(cars.size()).isEqualTo(INDICATOR_OF_ZERO_CAR);
    }
}
