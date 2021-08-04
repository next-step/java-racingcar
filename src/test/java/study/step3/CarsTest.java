package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.model.car.Car;
import study.step3.model.car.Cars;
import study.step3.model.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("Car Generate Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void carGenerateTest(int inputCarNumber) {
        Cars cars = Cars.of(inputCarNumber);
        assertThat(cars.getRacingGameCars().size()).isEqualTo(inputCarNumber);
    }

    @Test
    @DisplayName("Car Move Test")
    void carMoveTest() {
        int inputCarNumber = 3;
        Cars cars = Cars.of(inputCarNumber);

        for (Car car : cars.getRacingGameCars()) {
            MoveStrategy moveStrategy = () -> true;
            car.move(moveStrategy);
            assertThat(car.getDistance()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("Car Move Stop Test")
    void carStopTest() {
        int inputCarNumber = 3;
        Cars cars = Cars.of(inputCarNumber);

        for (Car car : cars.getRacingGameCars()) {
            MoveStrategy moveStrategy = () -> false;
            car.move(moveStrategy);
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }
}
