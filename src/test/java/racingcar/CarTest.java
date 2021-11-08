package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from();
    }

    @Test
    @DisplayName("전진")
    void move() {
        car.move(5);
        assertThat(car.currentPosition()).isEqualTo(Position.from(2).getPosition());
    }

    @Test
    @DisplayName("정지")
    void stop() {
        car.move(3);
        assertThat(car.currentPosition()).isEqualTo(Position.from(1).getPosition());
    }

    @Test
    @DisplayName("Car move exception test")
    void moveException() {

    }
}