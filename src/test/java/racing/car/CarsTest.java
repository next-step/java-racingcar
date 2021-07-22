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

    @DisplayName("Car Iterator Test")
    @Test
    public void carIteratorTest() {
        Cars cars = new Cars();
        for (int i = 0; i < 100; i++)
            cars.add(new Car());

        for (Car iCar : cars) {}
    }
}