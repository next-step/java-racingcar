package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step3.game.Car.START_LINE;

public class CarTest {

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void carCanMove() {
        Car car = new Car();
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차의 현재 위치를 알 수 있다.")
    void carCannotMove(int distance) {
        Car car = new Car();
        for (int i = 0; i < distance; i++) {
            car.move();
        }
        assertThat(car.getDistance()).isEqualTo(START_LINE + distance);
    }
}
