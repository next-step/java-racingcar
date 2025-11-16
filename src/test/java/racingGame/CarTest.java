package racingGame;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("전략이 true를 반환하면 자동차는 한 칸 전진한다")
    void move_whenStrategyIsTrue_increasePosition() {
        Car car = new Car();

        car.move(new AlwaysMoveStrategy());

        assertThat(car.position()).isEqualTo(1);
    }

    @Test
    @DisplayName("전략이 false를 반환하면 자동차는 이동하지 않는다")
    void move_whenStrategyIsFalse_positionNotChanged() {
        Car car = new Car();

        car.move(new NeverMoveStrategy());

        assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("여러 번 이동하면 누적 이동 거리가 올바르게 증가한다")
    void move_multipleTimes_accumulatesCorrectly() {
        Car car = new Car();

        car.move(new AlwaysMoveStrategy());
        car.move(new AlwaysMoveStrategy());
        car.move(new AlwaysMoveStrategy());

        assertThat(car.position()).isEqualTo(3);
    }
}
