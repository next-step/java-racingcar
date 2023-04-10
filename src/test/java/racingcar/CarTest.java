package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 움직인다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveSuccess(int value) {
        Car car = new Car(createRandom(value));
        car.move();

        assertThat(car.hasPositioned(1)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4보다 멈춰있다")
    @ValueSource(ints = {0, 1, 2, 3})
    void moveFail(int value) {
        Car car = new Car(createRandom(value));
        car.move();

        assertThat(car.hasPositioned(0)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 움직일수 있다")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMovable(int value) {
        Car car = new Car(createRandom(value));

        assertThat(car.isMovable()).isTrue();
    }
    @ParameterizedTest
    @DisplayName("랜덤값이 움직일수 있다")
    @ValueSource(ints = {0, 1, 2, 3})
    void isNotMovable(int value) {
        Car car = new Car(createRandom(value));

        assertThat(car.isMovable()).isFalse();
    }

    private Random createRandom(int value) {
        return new Random() {
            public int nextInt(int another) {
                return value;
            }
        };
    }
}