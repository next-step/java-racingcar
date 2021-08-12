package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.model.car.Car;
import study.step3.model.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7})
    @DisplayName("Car Move Test")
    void carMoveTest(int moveCount) {
        Car car = new Car();
        MoveStrategy moveStrategy = () -> true;

        for (int i = 0; i < moveCount; i++) {
            car.move(moveStrategy);
        }

        assertThat(car.getDistance()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7})
    @DisplayName("Car Stop Test")
    void carStopTest(int moveCount) {
        Car car = new Car();
        MoveStrategy moveStrategy = () -> false;

        for (int i = 0; i < moveCount; i++) {
            car.move(moveStrategy);
        }

        assertThat(car.getDistance()).isEqualTo(0);
    }
}
