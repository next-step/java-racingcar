package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("처음 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car(() -> true);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동 규칙이 허용하면 위치가 1 증가한다")
    void moveForwardByOneIfStrategyAllows() {
        Car car = new Car(() -> true);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 규칙이 허용하지 않으면 위치가 그대로다")
    void stayIfStrategyDisallows() {
        Car car = new Car(() -> false);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
