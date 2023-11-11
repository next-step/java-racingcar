package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.strategy.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차는 특정 조건을 만족할 때, 거리 1만큼 이동한다..")
    void 자동차_이동() {
        // given
        Car car = new Car();
        MovingStrategy forwardStrategy = () -> true;

        // when
        car.move(forwardStrategy);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 특정 조건을 만족하지 못하면, 정지한다.")
    void 자동차_정지() {
        // given
        Car car = new Car();
        MovingStrategy nonForwardStrategy = () -> false;

        // when
        car.move(nonForwardStrategy);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
