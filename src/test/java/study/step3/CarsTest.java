package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.model.car.Car;
import study.step3.model.car.Cars;
import study.step3.model.strategy.CarMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("Car Generate Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void carGenerateTest(int inputCarNumber) {
        Cars cars = Cars.of(inputCarNumber);
        assertThat(cars.getRacingGameCars().size()).isEqualTo(inputCarNumber);
    }

    @DisplayName("Car Move Test")
    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1"})
    void carMoveTest(int inputCarDistance, int expectedCarDistance) {
        int inputCarNumber = 3;
        Cars cars = Cars.of(inputCarNumber);

        for (Car car : cars.getRacingGameCars()) {
            car.move(new CarMoveStrategy(), inputCarDistance);
            assertThat(car.getDistance()).isEqualTo(expectedCarDistance);
        }
    }
}
