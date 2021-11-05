package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Car moveCar = car.move(() -> true);
        assertThat(moveCar.getPosition()).isEqualTo(Position.from(2));
    }

    @Test
    @DisplayName("정지")
    void stop() {
        Car moveCar = car.move(() -> false);
        assertThat(moveCar.getPosition()).isEqualTo(Position.from(1));
    }
}