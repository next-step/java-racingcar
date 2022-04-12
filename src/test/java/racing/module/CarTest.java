package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car = new Car(0);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("이동값이 4미만일때는 움직이지 않는다.")
    void dontMove(int speed) {
        car.move(speed);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("이동값이 4이상일때는 움직인다.")
    void move(int speed) {
        car.move(speed);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}