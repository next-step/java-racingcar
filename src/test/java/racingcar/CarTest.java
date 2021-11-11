package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.exception.CarMovingNumberException;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from(CarName.from("AA"));
    }

    @Test
    @DisplayName("전진")
    void move() {
        car.move(5);
        assertThat(car.currentPosition()).isEqualTo(Position.from(1).getPosition());
    }

    @Test
    @DisplayName("정지")
    void stop() {
        car.move(3);
        assertThat(car.currentPosition()).isEqualTo(Position.from(0).getPosition());
    }

    @ParameterizedTest
    @DisplayName("Car move exception test")
    @ValueSource(ints = {-1})
    void moveException(int number) {
        assertThatThrownBy(() -> car.move(number)).isInstanceOf(CarMovingNumberException.class);
    }
}