package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MovingStrategy;
import step4.strategy.RandomNumMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("생성된 자동차는 이름을 가진다.")
    void carHasNameTest() {
        Car testCar = new Car("자바");

        assertThat(testCar.name()).isEqualTo("자바");
    }

    @Test
    @DisplayName("자동차가 전진한다.")
    void move() {
        MovingStrategy movingStrategy = new RandomNumMovingStrategy() {
            @Override
            public boolean canForward() {
                return true;
            }
        };

        Car car = new Car("망고", movingStrategy);
        car.move();

        assertThat(car.distance()).isEqualTo(1);
    }
}
