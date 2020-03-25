package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Distance;
import racingcar.policy.MovingPolicy;
import racingcar.policy.fake.SuccessMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private MovingPolicy movingPolicy;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("pobi"), new Distance());
        movingPolicy = new SuccessMovingPolicy();
    }

    @DisplayName("자동차 이동을 성공한다.")
    @Test
    void move() {
        // when
        car.move(movingPolicy);

        // then
        assertThat(car.currentDistance().toInt()).isEqualTo(1);
    }
}