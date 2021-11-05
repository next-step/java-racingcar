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
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(Position.from(2));
    }

    @Test
    @DisplayName("정지")
    void stop() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(Position.from(1));
    }
}