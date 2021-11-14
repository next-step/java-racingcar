package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarMovingNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from(Name.from("AA"));
    }

    @ParameterizedTest
    @DisplayName("전진")
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void move(int value) {
        car.move(value);
        assertThat(car.currentPosition()).isEqualTo(Position.from(1));
    }

    @ParameterizedTest
    @DisplayName("정지")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void stop(int value) {
        car.move(value);
        assertThat(car.currentPosition()).isEqualTo(Position.from(0));
    }

    @ParameterizedTest
    @DisplayName("Car move exception test")
    @ValueSource(ints = {-1, 10})
    void moveException(int number) {
        assertThatThrownBy(() -> car.move(number)).isInstanceOf(CarMovingNumberException.class);
    }
}