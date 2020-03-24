package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.policy.MovingPolicy;
import racingcar.policy.fake.SuccessMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final int DEFAULT_DISTANCE = 0;
    private MovingPolicy movingPolicy;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", DEFAULT_DISTANCE);
        movingPolicy = new SuccessMovingPolicy();
    }

    @DisplayName("자동차 이동을 성공한다.")
    @Test
    void move() {
        // when
        car.move(movingPolicy);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}