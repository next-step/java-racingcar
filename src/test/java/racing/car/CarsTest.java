package racing.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.car.Car;
import racing.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {
    private static Cars cars;
    @BeforeAll
    public static void setUp() {
        cars = new Cars();
    }

    @DisplayName("Car Add Test")
    @ValueSource(ints = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    })
    @ParameterizedTest
    public void addTest(int size) {
        Car car = new Car();
        cars.add(car);
        assertThat(cars.size())
                .isEqualTo(size);
    }
}