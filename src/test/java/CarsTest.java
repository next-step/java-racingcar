import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("Cars 인스턴스를 생성한다.")
    void createCarsTest(int carCount) {
        Cars cars = Cars.createCars(carCount);
        assertThat(cars.cars).hasSize(carCount);
    }
}