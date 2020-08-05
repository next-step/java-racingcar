package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private int size;
    private Car[] cars;

    @BeforeEach
    void setUp() {
        size = 10;
        cars = Car.createAllCars(size);
    }
    
    @Test
    void createAllCarsTest() {
        assertThat(cars).hasSize(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void moveStopTest(int fuel) {
        List<Integer> expected = Car.getPositions(cars);

        for (Car car : cars) {
            car.move(fuel);
        }

        List<Integer> actual = Car.getPositions(cars);

        assertThat(expected).hasSameElementsAs(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void moveForwardTest(int fuel) {
        List<Integer> prev = Car.getPositions(cars);

        for (Car car : cars) {
            car.move(fuel);
        }

        List<Integer> next = Car.getPositions(cars);

        assertThat(prev).doesNotContainAnyElementsOf(next);

        int expected = prev.get(0) + 1;
        int actual = next.get(0);

        assertThat(expected).isEqualTo(actual);
    }
}