package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @DisplayName("Car 이동하기")
    @ValueSource(ints = {0, 1, 2})
    void moveCar(int movementExpected) {
        Car car = new Car(() -> movementExpected);
        int initialPosition = car.getPosition();

        car.move();
        int movement = car.getPosition() - initialPosition;

        assertThat(movement).isEqualTo(movementExpected);
    }
}
