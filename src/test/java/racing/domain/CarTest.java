package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @Test
    @DisplayName("movable 전략 리턴 값이 true 일 때 1칸 이동")
    void move() {
        car = Car.of("benz", () -> true);
        car.move();
        assertThat(car.getDistance().getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("movable 전략 리턴 값이 false 일 때 거리 변화 없음.")
    void stop() {
        car = Car.of("benz", () -> false);
        car.move();
        assertThat(car.getDistance().getDistance()).isEqualTo(0);
    }
}
