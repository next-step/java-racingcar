package racing.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;
import racing.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {
    @DisplayName("Car Add Test")
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    })
    @ParameterizedTest
    public void addTest(int size) {
        Cars cars = new Cars();
        cars.add(new Car());

        assertThat(cars.size())
                .isEqualTo(size);
    }

    @ValueSource(ints = { 0, 1, 100, 1000 })
    @DisplayName("Car Iterator Test")
    @ParameterizedTest
    public void carIteratorTest(int size) {
        Cars cars = new Cars();
        for (int i = 0; i < size; i++)
            cars.add(new Car());

        int i = 0;
        for (Car iCar : cars) {
            ++i;
        }
        assertThat(i)
                .isEqualTo(size);
    }
}